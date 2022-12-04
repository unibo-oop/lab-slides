using System;
using System.Collections.Generic;

namespace LinqOperations
{
    static class Program
    {
        // Generates an infinite stream of values by calling a function over and over again
        static IEnumerable<T> Generate<T>(Func<T> provider)
        {
            while (true)
                provider();
        }

        // Generates a stream of integers ranging from min to max, incremented by delta at each step
        static IEnumerable<int> Range<T>(int min, int max, int delta)
        {
            for (; min < max; min += delta)
                yield return min;
        }

        // Transforms the enumerable by applying a function to each item
        static IEnumerable<R> Select<T, R>(this IEnumerable<T> items, Func<T, R> transform)
        {
            foreach (var item in items)
                yield return transform(item);
        }

        // Filters out from the stream those items for which a predicate does not hold
        static IEnumerable<T> Where<T>(this IEnumerable<T> items, Func<T, bool> filter)
        {
            foreach (var item in items)
                if (filter(item))
                    yield return item;
        }

        // Only takes the first n items in the input enumerable
        static IEnumerable<T> Take<T>(this IEnumerable<T> items, int n)
        {
            foreach (var item in items)
            {
                if (n > 0)
                {
                    yield return item;
                    n--;
                }
                else yield break;
            }
        }

        // Gets the maximum value in a stream, given a comparer
        static T Max<T>(this IEnumerable<T> items, Func<T, T, int> comparer) where T : class
        {
            T max = null;
            foreach (var item in items)
                if (comparer(item, max) > 0)
                    max = item;
            return max;
        }

        // Gets the minimum value in a stream, given a comparer
        static T Min<T>(this IEnumerable<T> items, Func<T, T, int> comparer) where T : class =>
            items.Max((a, b) => -comparer(a, b));

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}