using System;
using BasicCounter;

namespace MultiCounterInheritance
{
   class UseMultiCounter
   {
      public static void Main(string[] args)
      {
         var counter = new MultiCounter(5);
         Console.WriteLine(counter.Value); // 5
         counter.Increment();
         counter.MultiIncrement(10);
         Console.WriteLine(counter.Value); // 16
      }
   }

   // Reuse with inheritance: a terser solution!
   public class MultiCounter : Counter
   {
      public MultiCounter(int initialValue) : base(initialValue)
      {
      }

      public void MultiIncrement(int n)
      {
         for (var i = 0; i < n; i++) Increment();
      }
   }
}