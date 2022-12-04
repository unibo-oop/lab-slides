using System;

namespace Snippets
{
    public static class MathUtils
    {
        public static long Factorial(long n)
        {
            if (n < 0)
            {   
                throw new ArgumentException("Cannot compute factorial of: " + n);
            }
            // control flow is broken in case of exception! -> don't need an else branch
            long result = 1;
            for (; n > 0; n--)
            {
                result *= n;
            }
            return result;
        }

        public static void Example(string[] args)
        {
            Factorial(4); // 24
            Factorial(-10); // ArgumentException
        }
    }
}