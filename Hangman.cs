namespace Hangman

{
    class Hangman
    {
        private static int dead_step = 6;
        private int step = 0;

        public Hangman() { }
        public void incrementStep() { step++; }
        public int getStep() { return step; }
        public bool isDead() { return step == dead_step; }
    }
}
