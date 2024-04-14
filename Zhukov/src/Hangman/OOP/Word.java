package Hangman.OOP;/* Старт игры

Первый класс: работа со словом
* Подобор слова
* Маскировка слова

второй класс: чтение инпута


третий класс: рендер

четвертый класс обработчик ошибок
**/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

class Word {
    public final static int START_COUNT = 1;
    public final static int END_COUNT = 49000;

    // чтение из файла
    // подбор слова -> рандомизатор
    public static String setStartWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Huawei\\Documents\\russian_nouns.txt"));
        StringJoiner joiner = new StringJoiner(" ");
        String line;

        while ((line = reader.readLine()) != null) joiner.add(line);

        String[] words = joiner.toString().split(" ");

        reader.close();

        return words[randomNumberForStartWord()];
    }

    private static int randomNumberForStartWord() {
        return START_COUNT + (int)(Math.random()*(END_COUNT-START_COUNT+1));
    }

    public static String[] makeMaskForStartWord(String word) {
        String[] mask = new String[word.length()];
        Arrays.fill(mask,"*");
        return mask;
    }
}