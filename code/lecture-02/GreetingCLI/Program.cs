using System;

namespace GreetingCLI
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length > 0)
            {
                Console.WriteLine(GreetingsLib.Greetings.Greeting(args[0]));
            }
            else
            {
                Console.WriteLine(GreetingsLib.Greetings.Greeting("<nobody>"));
            }
        }
    }
}