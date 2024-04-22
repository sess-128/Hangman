package Hangman;

import java.util.ArrayList;
import java.util.List;

public class LettersPool {
    private final List<Character> letters = new ArrayList<>();

    public LettersPool() {
    }

    public List<Character> toList() {
        return new ArrayList<>(letters);
    }


    public void addLetter(char letter) {
        letters.add(letter);
    }

    public boolean isLetterIncluded(char letter) {
        return letters.contains(letter);
    }
}
