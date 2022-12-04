using System;

namespace CatchingExceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            int readLines = 0;
            while (true)
            {
                String line = null;
                try
                {
                    Console.Write("> ");
                    line = Console.ReadLine();
                    int number = int.Parse(line);
                    Console.WriteLine("Valid integer: " + number);
                }
                catch (FormatException e)
                {
                    Console.WriteLine("Not a valid integer: " + line);
                }
                finally
                {
                    Console.WriteLine($"(So far I read {++readLines} lines)");
                }
            }
        }
    }
}