package Hangman.OOP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLetter {
    public static Scanner scanner = new Scanner(System.in);
    static Set<String> enteredLetters = new HashSet<String>();
    public static int countErrors = 0;


    public static void checkPlayerTurn(){
        System.out.println("Введите предполагаемую букву");
        String input = scanner.nextLine();

        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (input.length() != 1){
            System.out.println("Некорректный ввод: нужен всего 1 символ");
        } else if (!Character.isLetter(input.charAt(0)) || !matcher.find()){
            System.out.println("Некорректный ввод: нужно вводить только русскую букву");
        }

        if (enteredLetters.contains(input)){
            System.out.println("Вы уже вводили такую букву");
        } else {
            enteredLetters.add(input);
        }

    }
    public static char makePlayerTurn(){
        System.out.println("Введите предполагаемую букву");
        String input = scanner.next();
            if (input.length() != 1){
                System.out.println("Некорректный ввод: нужен всего 1 символ");
            } else if (!Character.isLetter(input.charAt(0))){
                System.out.println("Некорректный ввод: нужно вводить букву");
            }
            return input.charAt(0);
    }

    public void checkedPlayerTurn(String input){
        if (enteredLetters.contains(input)){
            System.out.println("Вы уже вводили такую букву");
        } else {
            enteredLetters.add(input);
        }
    }

    public void checkCorrectLetter(char input, String[] mask, String startWord){
        if (startWord.contains(String.valueOf(input))){
            for
            (int i = startWord.indexOf(input);
                 i > -1;
                 i = startWord.indexOf(input, i+1)
            )
            {
                mask[i] = String.valueOf(input);
            }
        } else {
            System.out.println("Вы ошиблись буквой, попробуйте еще раз");
            countErrors++;
        }
    }
    

}
