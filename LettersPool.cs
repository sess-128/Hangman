public class LettersPool()
{
    private List<Char> pool = new List<Char>();

    public void add(char c) { pool.Add(c); }
    public bool contains(char c) { return pool.Contains(c); }
    public List<Char> toList() { return new List<Char>(pool); }
   
}