package Hangman.OOP;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String word = Word.setStartWord();
        String[] mask = Word.makeMaskForStartWord(word);
        InputLetter input = new InputLetter();

        while (true) {
            char c = input.makePlayerTurn();
            input.checkPlayerTurn(c);
            input.checkCorrectLetter(c, mask, word);
        }
    }
}
