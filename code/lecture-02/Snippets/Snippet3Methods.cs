using System;
using System.Text;

namespace Snippets
{
    public class Snippet3Methods
    {
        public static void SomeMethodInvocations()
        {
            Math.Sqrt(4); // 2
            Console.WriteLine("Hello world!"); // prints "Hello world!" 
            new StringBuilder("{").Append(1).Append(", ").Append("2}").Length.Equals(6); // true
        }
        
        public static UInt64 Factorial(UInt64 n)
        {
            UInt64 result = 1;
            for (; n > 0; n--)
            {
                result *= n;
            }
            return result;
        }

        public static UInt64? Factorial(Int64 n)
        {
            if (n < 0)
            {
                return null;
            }
            return Factorial((UInt64) n);
        }
    }
}