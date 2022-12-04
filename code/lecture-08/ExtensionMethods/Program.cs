using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;

namespace ExtensionMethods
{
    static class Program
    {
        public static string ToAlternateCase(this string input)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.Length; i++)
            {
                var currentChar = "" + input[i];
                sb.Append(i % 2 == 0 ? currentChar.ToUpper() : currentChar.ToLower());
            }
            return sb.ToString();
        }

        public static string ToString<T>(this IEnumerable<T> items, string delimiter, 
            string prefix, string suffix)
        {
            StringBuilder sb = new StringBuilder(prefix);
            var e = items.GetEnumerator();
            if (e.MoveNext()) sb.Append(e.Current.ToString());
            while (e.MoveNext())
            {
                sb.Append(delimiter);
                sb.Append(e.Current.ToString());
            }
            sb.Append(suffix);
            return sb.ToString();
        } 

        public static string ToUpper(this string input) => 
            throw new ArgumentException("Error.");
        
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!".ToAlternateCase()); // HeLlO WoRlD!
            Console.WriteLine(ToAlternateCase("Hello World!")); // HeLlO WoRlD!

            IEnumerable<string> list = new List<string>() {"a", "b", "c"};
            Console.WriteLine(list.ToString(", ", "[", "]")); // [a, b, c]

            IEnumerable<int> enumerable = Enumerable.Range(1, 5);
            Console.WriteLine(enumerable.ToString("; ", "(", ")")); // (1; 2; 3; 4; 5)

            Console.WriteLine("Hello World!".ToUpper()); // HELLO WORLD!
            Console.WriteLine(ToUpper("Hello World!")); // System.ArgumentException: Error.
        }
    }
}