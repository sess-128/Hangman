package Hangman;

import Hangman.Common.HangmanRender;
import Hangman.Common.LettersPoolRender;
import Hangman.Common.WordRender;

import java.io.IOException;

import static Hangman.InputLetter.input;

public class Main {
    public static void main(String[] args) throws IOException {

        Word word = new Word();
        WordRender wordRender = new WordRender();

        LettersPoolRender renderPool = new LettersPoolRender();
        LettersPool lettersPool = new LettersPool();

        Hangman hangman = new Hangman();
        HangmanRender hangmanRender = new HangmanRender();

        Player player = new Player();
        GameState gameState = new GameState();


        hangmanRender.show(hangman);
        wordRender.show(word);
        renderPool.show(lettersPool);

        while (true) {
            char letter = input().charAt(0);


            if (lettersPool.isLetterIncluded(letter)) {
                System.out.println("Уже вводили такую букву");
            } else if (word.isLetterInWord(letter)) {
                lettersPool.addLetter(letter);
                player.incrementStep();
            } else {
                lettersPool.addLetter(letter);
                hangman.incrementStep();
                System.out.println("Такой буквы нет в слове");
            }
            hangmanRender.show(hangman);
            wordRender.show(word);
            renderPool.show(lettersPool);
            gameState.checkState(word, player, hangman);


        }

    }
}
