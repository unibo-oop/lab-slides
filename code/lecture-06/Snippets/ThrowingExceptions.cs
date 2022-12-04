using System;

namespace Snippets
{
    public static class ThrowingExceptions
    {
        public static void Example1(string[] args)
        {
            throw new ArgumentException("Argument must be a non-empty array: " + args);
        }
        
        public static void Example2(string[] args)
        {
            var e = new ArgumentException("Argument must be a non-empty array: " + args);
            // ...
            throw e;
        }
        
        public static void Example3(string[] args)
        {
            ArgumentException Error(string message) => new ArgumentException(message);
            // ...
            throw Error("Argument must be a non-empty array: " + args);
        }
        
        static void Recursive(int x)
        {
            if (x < 5)
            {
                Recursive(x + 1);
                Console.WriteLine(x);
            }
            else
            {
                throw new Exception("" + x);
            }
        }
        
        public static void Example4(string[] args)
        {
            Recursive(1);
        }
    }
}