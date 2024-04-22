package Hangman;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class Word {
    private final static int START_COUNT = 1;
    private final static int END_COUNT = 49000;
    private final static String FILE_PATH = "./src/Hangman/Common/russianWords.txt";

    private final char[] word;
    private final char[] mask;

    public Word() throws IOException {
        this.word = getWordFromFile();
        this.mask = makeMask();
    }

    public char[] getMask() {
        return mask;
    }

    public char[] getWord() {
        return word;
    }

    public boolean isLetterInWord(char letter) {
        if (Arrays.toString(word).contains(String.valueOf(letter))) {
            replaceLetter(letter);
            return true;
        }
        return false;
    }

    private void replaceLetter(char letter) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                mask[i] = letter;
            }
        }
    }

    private char[] makeMask() {
        char[] mask = new char[word.length];
        Arrays.fill(mask, '*');
        return mask;
    }

    private char[] getWordFromFile() throws IOException {
        File file = new File(FILE_PATH);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringJoiner joiner = new StringJoiner(" ");

        String line;
        while ((line = reader.readLine()) != null) joiner.add(line);
        String[] letters = joiner.toString().split(" ");
        reader.close();

        return letters[numberForWord()].toCharArray();
    }

    private int numberForWord() {
        return START_COUNT + (int) (Math.random() * (END_COUNT - START_COUNT + 1));
    }

}
