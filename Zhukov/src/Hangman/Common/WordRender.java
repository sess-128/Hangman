package Hangman.Common;

import Hangman.Word;

import java.io.IOException;

public class WordRender {
    public void show(Word wordTest) throws IOException {
//        System.out.println(wordTest.getWord());
        System.out.println(wordTest.getMask());
    }
}
