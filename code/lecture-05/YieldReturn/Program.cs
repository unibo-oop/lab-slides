using System;
using System.Collections.Generic;

namespace YieldReturn
{
   class UseYieldReturn
   {
      public static void Main(string[] args)
      {
         var helpers = new Helpers();

         foreach (var i in helpers.RangeWithDelta(0, -10, -2))
         {
            Console.Write(i + " ");
         }
         Console.WriteLine("");
         foreach (var d in helpers.Directions())
         {
            Console.Write(d + " ");
         }
         Console.WriteLine("");
         var fib = helpers.FibonacciInfiniteEnumerator();
         while (true)
         {
            fib.MoveNext();
            Console.Write(fib.Current + " ");
            if (fib.Current > 1000) break;
         }

         fib.Dispose();
      }
   }

   public class Helpers
   {
      public IEnumerable<int> RangeWithDelta(int start, int stop, int delta)
      {
         for (var i = start; i != stop; i += delta) yield return i;
      }

      public IEnumerable<string> Directions()
      {
         yield return "NORTH";
         yield return "EAST";
         yield return "SOUTH";
         yield return "WEST";
      }

      public IEnumerator<int> FibonacciInfiniteEnumerator()
      {
         yield return 1;
         int a = 1;
         int b = 1;
         while (true)
         {
            yield return b;
            int sum = a + b;
            a = b;
            b = sum;
         }
      }
   }
}