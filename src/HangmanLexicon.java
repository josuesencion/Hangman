/*
 *
 * Author: Josue Sencion
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HangmanLexicon {
    private String fileName = "HangmanLexicon.txt";
    private String fileName2 = "ShorterLexicon.txt";
    private String randWord;
    private String hint;


    public HangmanLexicon() {
        this.randWord = retrieveRandomWord();
        this.hint = hintGen();
    }

    public String getRandWord() {
        return randWord;
    }

    public String getHint() {
        return hint;
    }

    public ArrayList<String> retrieveLexicon() {
        ArrayList<String> lexicon = new ArrayList<>();
        String word;
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            while ((word = file.readLine()) != null) {
                lexicon.add(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lexicon;
    }

    private String retrieveRandomWord() {
        ArrayList<String> lex = retrieveLexicon();
        Random rand = new Random();
        return lex.get(rand.nextInt(lex.size()));
    }

    private String hintGen() {
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < this.randWord.length(); i++) {
            hint.append("-");
        }
        return hint.toString();
    }

}