package Hangman.Common;

import Hangman.LettersPool;

import java.util.List;

public class LettersPoolRender {
    public void show(LettersPool lettersPool) {
        List<Character> list = lettersPool.toList();
        System.out.print("Использованные буквы: ");
        for (Character c : list) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
