namespace Hangman.Common
{
    internal class HangmanRender
    {
    private static String GALLOWS = "-----------\n" + "||       |\n" + "||\n" + "||\n" + "||\n" + "----\n";
    private static String HANGMAN_HEAD = "-----------\n" + "||       |\n" + "||       0\n" + "||\n" + "||\n" + "----\n";
    private static String HANGMAN_BODY = "-----------\n" + "||       |\n" + "||       0\n" + "||       O\n" + "||\n" + "----\n";
    private static String HANGMAN_ONE_HAND = "-----------\n" + "||       |\n" + "||       0\n" + "||      /O\n" + "||\n" + "----\n";
    private static String HANGMAN_TWO_HANDS = "-----------\n" + "||       |\n" + "||       0\n" + "||      /O\\\n" + "||\n" + "----\n";
    private static String HANGMAN_ONE_LEG = "-----------\n" + "||       |\n" + "||       0\n" + "||      /O\\\n" + "||      /   \n" + "----\n";
    private static String HANGMAN_ONE_LEGS = "-----------\n" + "||       |\n" + "||       0\n" + "||      /O\\\n" + "||      / \\\n" + "----\n";
    private static String[] PICTURES = { GALLOWS, HANGMAN_HEAD, HANGMAN_BODY, HANGMAN_ONE_HAND, HANGMAN_TWO_HANDS, HANGMAN_ONE_LEG, HANGMAN_ONE_LEGS };


        public void showHangman(Hangman hangman)
        {
            int step = hangman.getStep();
            Console.WriteLine(PICTURES[step]);
        }
    };
}

