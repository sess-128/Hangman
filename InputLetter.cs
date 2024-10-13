using System.Text.RegularExpressions;

public class InputLetter
{
    public static char input()
    {
        Console.WriteLine("Введите букву: ");
        String userInput = Console.ReadLine();

        Regex regex = new Regex(@"[а-яёА-ЯЁ]");
        MatchCollection match = regex.Matches(userInput);

        if (userInput.Length != 1) { Console.WriteLine("Некорректный ввод: Введите 1 символ"); }
        else if (match.Count != 1) { Console.WriteLine("Некорректный ввод: Введите русскую букву!"); }
        return userInput.ToCharArray()[0];
    }
}
