using Hangman.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hangman
{
    class Program
    {
        private static string file_path = @"..\..\..\Common\russianWords.txt";
        static void Main()
        {
            WordRepository repository = new WordRepository(file_path);

            HangmanRender hangmanRender = new HangmanRender();
            Word word = new Word(repository.getRandom());

            Game game = new Game(word, hangmanRender);

            
            
            game.start();
        }
    }
}
