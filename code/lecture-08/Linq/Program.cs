using System;
using System.Collections.Generic;
using System.Linq;

namespace Linq
{
    class Program
    {
        static IEnumerable<int> GetTripledFirstNEvenNumbers1(IEnumerable<int> items, int n)
        {
            var list = new List<int>();
            foreach (var item in items)
            {
                if (item % 2 == 0)
                {
                    list.Add(item * 3);
                }
            }
            return list.GetRange(0, Math.Min(n, list.Count));
        }

        static IEnumerable<int> GetTripledFirstNEvenNumbers2(IEnumerable<int> items, int n)
        {
            var list = new List<int>();
            foreach (var item in items)
            {
                if (item % 2 == 0)
                {
                    list.Add(item * 3);
                    n--;
                }
                if (n == 0) break;
            }
            return list;
        }

        static IEnumerable<int> GetTripledFirstNEvenNumbers3(IEnumerable<int> items, int n)
        {
            foreach (var item in items)
            {
                if (item % 2 == 0)
                {
                    yield return item * 3;
                    n--;
                }
                if (n == 0) yield break;
            }
        }

        static IEnumerable<int> GetTripledFirstNEvenNumbers4(IEnumerable<int> items, int n) =>
            items.Where(item => item % 2 == 0)
                .Select(even => even * 3)
                .Take(n);

        static IEnumerable<int> GetTripledFirstNEvenNumbers5(IEnumerable<int> items, int n) =>
            (
                from item in items
                where item % 2 == 0
                select item * 3
            ).Take(n);

        static void PrintEnumerable<T>(IEnumerable<T> items)
        {
            Console.WriteLine(string.Join(", ", items));
        }
        
        static IEnumerable<int> RandomSequenceOfIntegers(int max, int size)
        {
            var random = new Random();
            for (; size > 0; size--)
                yield return random.Next(max + 1);
        }
        
        static void Main(string[] args)
        {
            var numbers = RandomSequenceOfIntegers(10, 20).ToList();
            PrintEnumerable(numbers);
            PrintEnumerable(GetTripledFirstNEvenNumbers1(numbers, 4));
            PrintEnumerable(GetTripledFirstNEvenNumbers2(numbers, 4));
            PrintEnumerable(GetTripledFirstNEvenNumbers3(numbers, 4));
            PrintEnumerable(GetTripledFirstNEvenNumbers4(numbers, 4));
            PrintEnumerable(GetTripledFirstNEvenNumbers5(numbers, 4));
        }
    }
}