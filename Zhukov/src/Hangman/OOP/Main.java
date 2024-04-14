package Hangman.OOP;
import java.io.IOException;
import static Hangman.OOP.InputLetter.makePlayerTurn;

public class Main {
    public static void main(String[] args) throws IOException {

        String word = Word.setStartWord();
        String[] mask = Word.makeMaskForStartWord(word);
        InputLetter input = new InputLetter();
        System.out.println(word);

        while (true) {

            input.replaceToCorrectLetter(makePlayerTurn(word), mask, word);
            Render.renderer(mask);
        }
    }
}
