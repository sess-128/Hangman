using System.IO;
using System.Reflection.PortableExecutable;

namespace Hangman;
internal class WordRepository
{
    private string file_path;
    public WordRepository(String file_path)
    {
        this.file_path = file_path;
    }

    public int randomNumber()
    {
        Random random = new Random();
        return random.Next(0, 10);
    }
    public string getRandom()
    {
        using (StreamReader reader = new StreamReader(file_path))
        {  
            string[] someWords = File.ReadAllLines(file_path);
            return someWords[randomNumber()];
        }
    }
}