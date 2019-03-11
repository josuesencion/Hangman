/*
*
* Author: Josue Sencion
*
*/

import java.util.Scanner;

public class HangmanApp {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!");

        char playAgain;

        do {
            HangmanLexicon lexicon = new HangmanLexicon();
            Hangman game = new Hangman(lexicon.getRandWord(), lexicon.getHint());

            while (!game.compareSecretWord() && game.getGuessesLeft() != 0) {
                game.displayHint();
                game.showGuessesLeft();
                System.out.print("Your guess: ");
                char guess = scanner.nextLine().toUpperCase().charAt(0);
                game.verifyGuess(guess);
            }

            if (game.compareSecretWord()) {
                System.out.println("You guessed the word: " + game.getSecretWord());
            } else {
                System.out.println("You lost. The word is: " + game.getSecretWord());
            }

            System.out.print("Would you like to play again? Y/N: ");
            playAgain = scanner.nextLine().charAt(0);
        } while (playAgain == 'Y' || playAgain == 'y');

        scanner.close();
    }
}
