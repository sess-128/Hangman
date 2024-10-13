namespace Hangman.Common
{
    internal class LettersPoolRender
    {
        public void show(LettersPool pool)
        {
            List<Char> list = pool.toList();
            Console.Write("Использованные буквы: ");
            for (int i = 0; i < list.Count; i++) { Console.Write(list[i] + " "); }
            Console.WriteLine();
        }
    }
}
