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
    private String[] stickFig;

    public Hangman(String secretWord, String hint) {
        this.secretWord = secretWord;
        this.hint = hint;
        this.guessesLeft = 8;
        this.wordLength = secretWord.length();
        this.stickFig = stickFigure();
    }

    private String[] stickFigure(){

        // _____
        //|     |
        //|     O
        //|    /|\
        //|     |
        //|    / \
        //|
        //|

        String[] figure = new String[8];

        figure[0] = " _____ ";
        figure[1] = "|";
        figure[2] = "|";
        figure[3] = "|";
        figure[4] = "|";
        figure[5] = "|";
        figure[6] = "|";
        figure[7] = "|";

        return figure;
    }

    public void drawStickFigure() {

        switch (this.guessesLeft) {
            case 7:
                this.stickFig[1] = "|     |";
                break;
            case 6:
                this.stickFig[2] = "|     O";
                break;
            case 5:
                this.stickFig[3] = "|     |";
                break;
            case 4:
                this.stickFig[3] = "|    /|";
                break;
            case 3:
                this.stickFig[3] = "|    /|\\";
                break;
            case 2:
                this.stickFig[4] = "|     |";
                break;
            case 1:
                this.stickFig[5] = "|    / ";
                break;
            case 0:
                this.stickFig[5] = "|    / \\";
                break;
        }

        for (String fig:this.stickFig
             ) {
            System.out.println(fig);
        }
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
