package Hangman.OOP;

import java.util.Arrays;

public class Render {
    public static final String ZERO_ERRORS ="-----------\n" +
                                            "||       |\n" +
                                            "||\n" +
                                            "||\n" +
                                            "||\n" +
                                            "----\n";
    public static final String ONE_ERROR ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||\n" +
            "||\n" +
            "----\n";
    public static final String TWO_ERRORS ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||       O\n" +
            "||\n" +
            "----\n";
    public static final String THREE_ERRORS ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||      /O\n" +
            "||\n" +
            "----\n";
    public static final String FOUR_ERRORS ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||      /O\\\n" +
            "||\n" +
            "----\n";
    public static final String FIVE_ERRORS ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||      /O\\\n" +
            "||      /   \n" +
            "----\n";
    public static final String SIX_ERRORS ="-----------\n" +
            "||       |\n" +
            "||       0\n" +
            "||      /O\\\n" +
            "||      / \\\n" +
            "----\n";

    public static void renderer(String[] mask){
        switch (InputLetter.countErrors){
            case 0:
                System.out.println(ZERO_ERRORS); break;
            case 1:
                System.out.println(ONE_ERROR); break;
            case 2:
                System.out.println(TWO_ERRORS); break;
            case 3:
                System.out.println(THREE_ERRORS);break;
            case 4:
                System.out.println(FOUR_ERRORS);break;
            case 5:
                System.out.println(FIVE_ERRORS);break;
            case 6:
                System.out.println(SIX_ERRORS);break;
        }
        System.out.println("Кол-во ошибок: " + InputLetter.countErrors);
        System.out.println("Использованные буквы: " + InputLetter.enteredLetters);
        System.out.println(Arrays.toString(mask)+"\n");
    }
}
