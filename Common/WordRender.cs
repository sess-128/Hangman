namespace Hangman.Common
{
    internal class WordRender
    {
        public void show(Word word) { Console.WriteLine(word.getMask());}

        public void showLetters(Word word) { Console.WriteLine(word.getLetters());}
    }
}
