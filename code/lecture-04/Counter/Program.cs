using System;

namespace BasicCounter
{
   class UseCounter
   {
      public static void Main(string[] args)
      {
         var counter = new Counter(5);
         Console.WriteLine(counter.Value); // 5
         counter.Increment();
         counter.Increment();
         counter.Increment();
         Console.WriteLine(counter.Value); // 8
      }
   }

   public class Counter
   {
      public int Value { get; private set; }

      public Counter(int initialValue) => Value = initialValue;

      public void Increment() => Value++;
   }
}