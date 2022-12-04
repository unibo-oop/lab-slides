using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace ForEach
{
    class Program
    {
        static void Main(string[] args)
        {
            var container = new string[] {"a", "b", "c"};
            foreach (string item in container)
            {
                Console.WriteLine(item); // a, b, c
            }
            
            IEnumerable<string> collection = new Collection<string> {"b", "c", "a"};
            IEnumerator<string> enumerator = collection.GetEnumerator();
            while (enumerator.MoveNext())
            {
                Console.WriteLine(enumerator.Current); // b, c, a
            }
            Console.WriteLine(enumerator.MoveNext()); // false
            Console.WriteLine(enumerator.Current ?? "null"); // null
        }
    }
}