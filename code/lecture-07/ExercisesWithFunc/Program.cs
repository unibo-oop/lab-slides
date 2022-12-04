using System;
using System.Collections.Generic;
using static ExercisesWithFunc.GeneralizedHelpers;

namespace ExercisesWithFunc
{
   class Helpers {
      
      public static void ShowAll(IEnumerable<int> elems)
      {
         foreach (var e in elems) Console.WriteLine(e); 
      }
      
      public static IEnumerable<int> GetAllPositive(IEnumerable<int> elems)
      {
         foreach (var e in elems) if (e>0) yield return e; 
      }
      
      public static IEnumerable<int> IncrementAll(IEnumerable<int> elems)
      {
         foreach (var e in elems) yield return e+1; 
      }
      
      public static int SumAll(IEnumerable<int> elems)
      {
         var sum = 0;
         foreach (var e in elems) sum += e;
         return sum;
      }

      public static IEnumerable<int> Iterate(int size)
      {
         for (var i=0; i<size; i++) yield return i;
      }
   }
   
   class GeneralizedHelpers
   {
      // Generalizing ShowAll
      public static void ForEach<T>(IEnumerable<T> elems, Action<T> action)
      {
         foreach (var e in elems) action(e);
      }

      // Generalizing GetAllPositive
      public static IEnumerable<T> Filter<T>(IEnumerable<T> elems, Predicate<T> pred)
      {
         foreach (var e in elems)
            if (pred(e)) yield return e;
      }

      // Generalizing Increment
      public static IEnumerable<TResult> Map<TResult, T>(IEnumerable<T> elems, Func<T, TResult> map)
      {
         foreach (var e in elems) yield return map(e);
      }

      // Generalize the others by yourself!
   }
   
   class UseGeneralizedHelpers
   {
      static void Main(string[] args)
      {
         var list = new List<string>(new[] {"a", "bb", "ccc", "dddd"});
         ForEach(list, s => Console.Write(s+"; ")); // a; bb; ccc; dddd;
         Console.WriteLine();

         var list2 = Filter(list, s => s.Length < 4);
         ForEach(list2, s => Console.Write(s+"; ")); // a; bb; ccc;
         Console.WriteLine();
         
         var list3 = Map(list, s => s.Length);
         ForEach(list3, s => Console.Write(s+"; ")); // 1; 2; 3;
         Console.WriteLine();
         
         // Generalize SumAll to extract from the above list: "abbcccdddd"
         // Use same generalization above to extract from the above list the shortest string
         // Generalize Increment to produce enumeration "a", "aa", "aaa",...
      }
   }
}