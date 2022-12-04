using System;

namespace MultiCounter
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

   public class MultiCounter
   {
      public int Value { get; private set; }

      public MultiCounter(int initialValue) => Value = initialValue;

      public void Increment() => Value++;

      public void MultiIncrement(int n)
      {
         for (var i = 0; i < n; i++) Increment();
      }
   }
}