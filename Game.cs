using Hangman.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hangman;

internal class Game
{
    private Word word;
    private HangmanRender hangmanRender;

    public Game(Word word, HangmanRender hangmanRender)
    {
        this.word = word;
        this.hangmanRender = hangmanRender;
    }

    public void start()
    {
        LettersPool lettersPool = new LettersPool();

        WordRender wordRender = new WordRender();
        LettersPoolRender poolRender = new LettersPoolRender();

        Hangman hangman = new Hangman();

        while (true)
        {
            char c = InputLetter.input();


            if (lettersPool.contains(c)) { Console.WriteLine("Вводили такую буквы"); continue; }
            lettersPool.add(c);


            if (word.contains(c))
            {
                word.openLetter(c);
            }
            else
            {
                hangman.incrementStep();
                Console.WriteLine("\nТакой буквы нет в слове");
            }

            wordRender.show(word);
            poolRender.show(lettersPool);


            if (Rules.isWin(word)) { printWin(); return; };
            if (Rules.isLose(hangman)) {printLose(); return;}

            hangmanRender.showHangman(hangman);
        }
    }
    public void printWin() 
    {
        Console.WriteLine("ПОБЕДА");
    }
    public void printLose()
    {
        Console.WriteLine("ПРОИГРЫШ");
    } 
}
