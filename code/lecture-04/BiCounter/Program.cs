using System;

namespace BiCounter
{
   class UseBiCounter
   {
      public static void Main(string[] args)
      {
         var counter = new BiCounter(5);
         Console.WriteLine(counter.Value); // 5
         counter.Increment();
         counter.Decrement();
         counter.Decrement();
         Console.WriteLine(counter.Value); // 4
      }
   }

   public class ExtendibleCounter
   {
      public int Value { get; protected set; }

      public ExtendibleCounter(int initialValue) => Value = initialValue;

      public void Increment() => Value++;
   }

   public class BiCounter : ExtendibleCounter
   {
      public BiCounter(int initialValue) : base(initialValue)
      {
      }

      public void Decrement() => Value--;
   }
}