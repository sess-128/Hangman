package Hangman;

public class Player {
    private int step;
    private int winStep;

    public Player() {
    }

    public void setWinStep(int winStep) {
        this.winStep = winStep;
    }

    public int getStep() {
        return step;
    }

    public boolean isWin() {
        return step == winStep;
    }

    public void incrementStep() {
        step++;
    }

}
