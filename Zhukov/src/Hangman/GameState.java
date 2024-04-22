package Hangman;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    private final static String PLAYER_WIN = "-----------------\n" + "ПОБЕДА!\n" + "-----------------";
    private final static String PLAYER_LOSE = "-----------------\n" + "ПРОИГРЫШ!\n" + "-----------------";
    public void checkState(Word word, Player player, Hangman hangman) {
        Set<Character> uniqueChars = new HashSet<>();
        char[] word1 = word.getWord();
        for (char c : word1) {
            uniqueChars.add(c);
        }
        player.setWinStep(uniqueChars.size());
        if (player.isWin()) {
            System.out.println(PLAYER_WIN);
            System.exit(1);
        } else if (hangman.isDead()) {
            System.out.println(PLAYER_LOSE + "\nБыло загадано слово: " + String.valueOf(word.getWord()));
            System.exit(1);
        }
    }
}
