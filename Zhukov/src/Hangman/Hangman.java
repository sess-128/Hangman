package Hangman;

public class Hangman {

    private final static int DEAD_STEP = 6;
    private int step;

    public Hangman() {
    }

    public int getStep() {
        return step;
    }

    public boolean isDead() {
        return step == DEAD_STEP;
    }

    public void incrementStep() {
        step++;
    }
}
