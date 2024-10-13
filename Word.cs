

namespace Hangman
{
    internal class Word
    {
        private char[] mask;
        private char[] letters; 

        public Word(String text)
        {
            this.letters = text.ToCharArray(); ;
            this.mask = makeMask();
            
        }
        public char[] getMask() {  return mask; }
        public char[] getLetters() { return letters; }
        public bool contains(char letter)
        {
            return letters.Contains(letter);
        }
        public void openLetter(char letter)
        {
            for (int i = 0; i < letters.Length; i++)
            {
                if (letters[i] == letter)
                {
                    mask[i] = letter;
                }

            }
        }
        public char[] makeMask()
        {
            char[] mask = new char[letters.Length];
            Array.Fill(mask, '*');
            return mask;
        }  
    }
}
