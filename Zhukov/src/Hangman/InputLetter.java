package Hangman;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLetter {
    private final static Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println("Введите букву:");
        String letter = scanner.nextLine();

        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letter);

        if (letter.length() != 1) {
            System.out.println("Некорректный ввод: нужен всего 1 символ");
        } else if (!Character.isLetter(letter.charAt(0)) || !matcher.find()) {
            System.out.println("Некорректный ввод: нужно вводить только русскую букву");
        }

        return letter;
    }
}
