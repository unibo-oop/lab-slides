using System;
using BasicCounter;

namespace MultiCounterWithDelegation
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

   // A nice reuse of existing Counter class!
   public class MultiCounter
   {
      private readonly Counter _counter;
      
      public MultiCounter(int initialValue) => 
         _counter = new Counter(initialValue);

      public int Value => _counter.Value;  // delegation

      public void Increment() => _counter.Increment(); // delegation
      
      public void MultiIncrement(int n)
      {
         for (var i = 0; i < n; i++) Increment();
      }
   }
}