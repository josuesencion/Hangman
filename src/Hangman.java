/*
 *
 * Author: Josue Sencion
 *
 */

import java.util.ArrayList;

public class Hangman {
    private String secretWord;
    private String hint;
    private int guessesLeft;
    private int wordLength;

    public Hangman(String secretWord, String hint) {
        this.secretWord = secretWord;
        this.hint = hint;
        this.guessesLeft = 8;
        this.wordLength = secretWord.length();
    }

    public void verifyGuess(char guess) {
        ArrayList<Integer> wordChars = new ArrayList<>();
        char wordChar;
        for (int i = 0; i < this.wordLength; i++) {
            wordChar = this.secretWord.charAt(i);
            if (guess == wordChar) {
                wordChars.add(i);
            }
        }
        if (!wordChars.isEmpty()) {
            modifyHint(wordChars, guess);
            wordChars.clear();
            System.out.println("That guess is correct.");
        } else {
            System.out.println("There are no " + guess + "'s in the word.");
            this.guessesLeft--;
        }

    }

    private void modifyHint(ArrayList<Integer> chars, char guess) {
        StringBuilder hintBuilder = new StringBuilder();
        for (int i = 0; i < this.wordLength; i++) {
            hintBuilder.append(chars.contains(i) ? guess : this.hint.charAt(i));
        }
        this.hint = hintBuilder.toString();
    }

    public boolean compareSecretWord() {
        return this.secretWord.equals(this.hint);
    }

    public void displayHint() {
        System.out.println("The word now looks like this: " + this.hint);
    }

    public void showGuessesLeft() {
        System.out.println("You have " + this.guessesLeft + " guesses left.");
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
