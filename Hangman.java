import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;



public class Hangman {
    static int countErrors = 0;
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
    public static String[] painter(String a) {
        String[] ris = new String[a.length()];
        Arrays.fill(ris, "*");
        lover(ris);
        return ris;
    }
    public static void lover(String[] a){
        Arrays.asList(a).stream().forEach(s -> System.out.print(s));
        System.out.println();
    }
    public static String[] replacer(String[] paint, String word, String change) {
        if (word.contains(change)) {
                for (int index = word.indexOf(change);
                     index > -1;
                     index = word.indexOf(change, index + 1)) {
                    paint[index] = change;
                }
                lover(paint);
            } else {
                    lover(paint);
                    countErrors++;
                    System.out.println("Кол-во ошибок: " + countErrors);
        }
    return paint;
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
        int firsrWordNumber = 1;
        int lastWordNumber = 49168;  // Длина массива words = количество слов = 49168
        int randomNumber = firsrWordNumber +(int)(Math.random()*(lastWordNumber-firsrWordNumber+1));
        return  randomNumber;
    }
    public static String makePlayerTurn() {
        System.out.println("Введите букву");
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.next();
        return playerInput;
    }
    public static void startHangman() throws IOException {
        String wordForHungman = getWord();
        String[] mask = painter(wordForHungman);
        while(true){
            String userInput = makePlayerTurn();
            replacer(mask, wordForHungman,userInput);
            paintHang(countErrors);
            checkGameState(mask);

            if (checkGameState(mask) == 5){
                System.out.println("Вы Победили!");
                break;
            }
            if (countErrors == 6){
                System.out.println("Вы повешены");
                System.out.println("Было загадано слово: "+wordForHungman);
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
        painHangHelp(top,top1,top2,bot2,bot1,bot);

    }
    public static void painHangHelp(String t, String t1, String t2, String b2, String b1,String b){
        System.out.println(t);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(b2);
        System.out.println(b1);
        System.out.println(b);
    }
}