using System;
using System.Text;

namespace Snippets
{
    public class Snippet4Conditions
    {
        public static void IfConstructExample()
        {
            int number = new Random().Next();
            if (number < 0)
            {
                Console.WriteLine("negative");
            }
            else if (number % 2 == 0)
            {
                if (number != 0) Console.Write("even");
            }
            else
            {
                Console.WriteLine("odd");
            }
        }
    }
}