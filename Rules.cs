using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hangman
{
    internal class Rules
    {
        public static bool isWin(Word word) 
        {
            char[] first = word.getLetters();
            char[] second = word.getMask();
            return Array.Equals(first, second);
        }
        public static bool isLose(Hangman hangman) 
        {
            return hangman.isDead();
        }
    }
}
