package Hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;



public class Hangman {
    static int countErrors = 0;
    static int maxErrors = 6;

    public static void main(String[] args) throws IOException {
        gameLoop();
    }
    // КОД ФУНКЦИОНИРОВАНИЯ //
    public static void gameLoop() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать новую игру? 1/0");
        int gameStart = scanner.nextInt();
        if (gameStart == 1) {
            System.out.println("У вас есть всего 6 ошибок. Удачной игры!");
            startHangman();
        } else if (gameStart == 0) {
            System.out.println("Всего хорошего!");
        }
    }
    public static String[] paintStartWordMask(String startWord) {
        String[] mask = new String[startWord.length()];
        Arrays.fill(mask, "*");
        paintWordMask(mask);
        return mask;
    }
    // [eqwww
    public static void paintWordMask(String[] wordWithLetters){
        Arrays.asList(wordWithLetters).forEach(System.out::print);
        System.out.println();
    }
    public static void changeToCorrectLetters(String[] paint, String startWord, String userInput) {
        if (startWord.contains(userInput)) {
                for (int index = startWord.indexOf(userInput);
                     index > -1;
                     index = startWord.indexOf(userInput, index + 1)) {
                    paint[index] = userInput;
                }
                paintWordMask(paint);
            } else {
                    paintWordMask(paint);
                    countErrors++;
                    System.out.println("Кол-во ошибок: " + countErrors);
        }
    }
    public static String getWord() throws IOException {

        // Считываем файл
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Huawei\\Documents\\russian_nouns.txt"));
        StringJoiner joiner = new StringJoiner(" ");
        String line;
            while ((line = reader.readLine()) != null) { // Из считываемых строк делаем большую строку
                joiner.add(line);
            }
        String joinerString = joiner.toString(); // Преобразуем все в одну строку
        String[] words = joinerString.split(" "); // Сплитуем по пробелу массив

        reader.close();
        return words[randomNumberForWord()];
    }
    public static int randomNumberForWord() {
        int firstWordNumber = 1;
        int lastWordNumber = 49168;  // Длина массива words = количество слов = 49168
        return firstWordNumber +(int)(Math.random()*(lastWordNumber-firstWordNumber+1));
    }
    public static String makePlayerTurn() {
        System.out.println("Введите букву");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static void startHangman() throws IOException {
        String wordForHangman = getWord();
        String[] mask = paintStartWordMask(wordForHangman);
        while(true){
            String userInput = makePlayerTurn();
            changeToCorrectLetters(mask, wordForHangman,userInput);
            paintHang(countErrors);
            checkGameState(mask);

            if (checkGameState(mask) == 5){
                System.out.println("Вы Победили!");
                break;
            }
            if (countErrors == maxErrors){
                System.out.println("Вы повешены");
                System.out.println("Было загадано слово: "+wordForHangman);
                break;
            }
        }
    }
    public static int checkGameState(String[] s) {
        String hello = Arrays.toString(s);

        if (!hello.contains("*")) {
            return 5;
        }
        return 10;
    }
    public static void paintHang (int a) {
        String top = "-----------";
        String top1 = "||       |";
        String top2 = "||";
        String bot2 = "||";
        String bot1 = "||";
        String bot = "----";
        switch (a){
            case 1 -> top2 += "       0";
            case 2 -> {
                top2 += "       0";
                bot2 += "       O";
                       }
            case 3 -> {
                top2 += "       0";
                bot2 += "      /O";
            }
            case 4 -> {
                top2 += "       0";
                bot2 += "      /O\\";
            }
            case 5 -> {
                top2 += "       0";
                bot2 += "      /O\\";
                bot1 += "      /   ";
            }
            case 6 -> {
                top2 += "       0";
                bot2 += "      /O\\";
                bot1 += "      / \\";
            }
        }
        paintHangHelp(top,top1,top2,bot2,bot1,bot);

    }
    public static void paintHangHelp(String t, String t1, String t2, String b2, String b1, String b){
        System.out.println(t);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(b2);
        System.out.println(b1);
        System.out.println(b);
    }
}