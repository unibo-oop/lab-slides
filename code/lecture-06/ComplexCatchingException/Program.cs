using System;

namespace ComplexCatchingException
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
                catch (FormatException e) { Console.WriteLine("Not a valid integer: " + line); }
                catch (OverflowException e) { Console.WriteLine("Out of range integer: " + line); }
                catch (ArgumentNullException e) { Console.WriteLine("Bye bye!"); break; }
                finally { Console.WriteLine($"(So far I read {++readLines} lines)"); }
            }
        }
    }
}