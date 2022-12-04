using System;

namespace Snippets
{
    public class Snippet2Expressions
    {
        public static void SomeExpressions()
        {
            Int32 expr1 = 1;
            Int32 expr2 = (1 + 2 - 3 * 4 / 5) % 6 << 7; // 128
            Int32 expr3 = (1 + 2 - 3 * Int32.Parse("4") / 5) % 6 << (int) long.Parse("6"); // 64
            String expr4 = (10 * 5).ToString() + " Cents"; // "50 Cents"
            String expr5 = "Blink " + 180 + 2; // "Blink 1802"
            String expr6 = "Blink " + 91 * 2; // "Blink 182"
            Boolean expr7 = expr2 == expr3 * 2; // true
            Boolean expr8 = expr1 < 0; // false
            Boolean expr9 = expr5.Equals(expr6.Replace("8", "80")); // true
        }
    }
}