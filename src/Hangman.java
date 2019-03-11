import java.util.ArrayList;

public class Hangman {
    private String secretWord;
    private String hint;
    private int guessesLeft;
    private int wordLength;

    public Hangman(String secretWord, String hint) {
        this.secretWord = secretWord;
        this.hint = hint;
        this.guessesLeft = 10;
        this.wordLength = secretWord.length();
    }

    public boolean vefiryGuess(char guess){
        ArrayList<Integer> wordChars = new ArrayList<>();
        char wordChar;
        for (int i = 0; i < this.wordLength; i++) {
            wordChar = this.secretWord.charAt(i);
            if(guess == wordChar){
                wordChars.add(i);
            }
        }
        if (!wordChars.isEmpty()) {
            modifyHint(wordChars, guess);
            wordChars.clear();
            System.out.println("That guess is correct.");
            return true;
        } else{
            System.out.println("There are no " + guess + "'s in the word.");
            this.guessesLeft--;
            return false;
        }

    }

    private void modifyHint(ArrayList<Integer> chars, char guess){
        StringBuilder hintBuilder = new StringBuilder();
        for (int i = 0; i < this.wordLength; i++) {
            if(chars.contains(i)){
                hintBuilder.append(guess);
            } else {
                hintBuilder.append(this.hint.charAt(i));
            }
        }
        this.hint = hintBuilder.toString();
    }

    public boolean compareSecretWord(){
        return this.secretWord.equals(this.hint);
    }

    public void displayHint(){
        System.out.println("The word now looks like this: " + this.hint);
    }

    public void showGuessesLeft(){
        System.out.println("You have " + this.guessesLeft + " guesses left.");
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }

    /*
    public int countChar()
    {
        int count = 0;

        for(int i=0; i < this.hint.length(); i++)
        {    if(this.hint.charAt(i) == '-')
            count++;
        }

        return count;
    }
    */
}
