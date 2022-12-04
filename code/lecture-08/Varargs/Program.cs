using System;
using System.Collections.Generic;
using System.Numerics;

namespace Varargs
{
    static class CollectionUtils
    {
        public static ISet<T> SetOf<T>(T first, params T[] others)
        {
            var set = new HashSet<T>();
            set.Add(first);
            foreach (var item in others) set.Add(item);
            return set;
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            // 1 + 2 parameters, implicit type
            var set1 = CollectionUtils.SetOf("a", "b", "c"); // type of set1 is ISet<string>
            foreach (string str in set1) Console.WriteLine(str); // a, b, c
            
            // 1 + 5 parameters, explicit type
            var set2 = CollectionUtils.SetOf<int>(1, 2, 2, 3, 4, 4); // type of set2 is ISet<int>
            foreach (int num in set2) Console.WriteLine(num); // 1, 2, 3, 4
            
            // 1 + 0 parameters, implicit type
            var set3 = CollectionUtils.SetOf(Complex.Zero); // type of set3 is ISet<Complex>
            foreach (Complex c in set3) Console.WriteLine(c); // 0
        }
    }
}