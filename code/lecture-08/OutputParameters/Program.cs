using System;
using System.Collections.Generic;

namespace OutputParameters
{
    static class Utils
    {
        public static bool TryFindIndex<T>(IEnumerable<T> list, T item, out uint index)
        {
            index = 0; // remove this line and the method won't compile
            foreach (var x in list)
            {
                if (x.Equals(item)) return true;
                index++;
            }
            return false;
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            var list = new List<string>() { "a", "d", "c", "b" };
            uint indexOfC;
            if (Utils.TryFindIndex(list, "c", out indexOfC))
            {
                Console.WriteLine(indexOfC); // 2
            }
            else
            {
                Console.WriteLine("not found"); // NOT PRINTED
            }
        }
    }
}