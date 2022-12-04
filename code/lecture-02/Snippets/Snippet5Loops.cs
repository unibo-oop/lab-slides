using System;
using System.Text;

namespace Snippets
{
    public class Snippet5Loops
    {
        public static void ForConstruct()
        {
            int max = 10;
            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    Console.Write(j + ", ");
                }
                Console.WriteLine();
            }
        }

        public static void WhileConstruct()
        {
            int max = 10, i = 0, j = 0;
            while (i < max)
            {
                j = 0;
                while (j <= i)
                {
                    Console.Write(j + ", ");
                    j++;
                }
                Console.WriteLine();
                i++;
            }
        }

        public static void DoWhileConstruct()
        {
            int max = 10, i = 0, j = 0;
            do
            {
                j = 0;
                do
                {
                    Console.Write(j + ", ");
                    j++;
                } while (j <= i);
                Console.WriteLine();
                i++;
            } while (i < max);
        }
    }
}