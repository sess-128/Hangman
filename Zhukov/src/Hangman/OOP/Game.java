package Hangman.OOP;

import static Hangman.OOP.InputLetter.*;

public class Game {
    public void checkGameState(){
        if (countErrors == 6) {
            System.out.println("Вы не отгадали! Правильное слово был");
        }
    }
}
