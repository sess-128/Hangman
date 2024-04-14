package Hangman.OOP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLetter {
    public static Scanner scanner = new Scanner(System.in);
    static Set<String> enteredLetters = new HashSet<>();
    public static int countErrors = 0;


    public static char makePlayerTurn(String startWord){
        System.out.println("Введите предполагаемую букву");
        String input = scanner.nextLine();

        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (true) {

            if (input.length() != 1) {
                System.out.println("Некорректный ввод: нужен всего 1 символ");
            } else if (!Character.isLetter(input.charAt(0)) || !matcher.find()) {
                System.out.println("Некорректный ввод: нужно вводить только русскую букву");
            }

            if (!startWord.contains(input)) {
                System.out.println("Вы ошиблись буквой!");
                countErrors++;
            }

            if (enteredLetters.contains(input)) {
                System.out.println("Вы уже вводили такую букву");
            } else {
                enteredLetters.add(String.valueOf(input.charAt(0)));
            }
            return input.charAt(0);
        }
    }

    public void replaceToCorrectLetter(char input, String[] mask, String startWord){
        if (startWord.contains(String.valueOf(input))){
            for
            (int i = startWord.indexOf(input);
                 i > -1;
                 i = startWord.indexOf(input, i+1)
            )
            {
                mask[i] = String.valueOf(input);
            }
        }
    }
    

}
