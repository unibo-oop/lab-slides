using System;

namespace Aula
{
   class A 
   {
      public override string ToString()
      {
         return "ciao, sono un oggetto di A";
      }
   }

   class UseMultiCounter
   {
      public static void Main(string[] args)
      {
         Counter counter = new LimitCounter(5);
         counter.Increment();
         Console.WriteLine(counter.Value);
         Console.WriteLine(counter.ToString());
         IncrementTwice(new Counter(6));
         IncrementTwice(new LimitCounter(6));
      }

      public static void IncrementTwice(Counter counter)
      {
         counter.Increment();
         counter.Increment();
      }
   }

   public class Counter
   {
      public int Value { get; private set; }

      public Counter(int initialValue) => Value = initialValue;

      public virtual void Increment() => Value++;
   }
   
   // Reuse with inheritance: a terser solution!
   public class LimitCounter : Counter
   {
      public LimitCounter(int initialValue) : base(initialValue)
      {
      }
      
      public override void Increment()
      {
         if (IsOver()) base.Increment();
      }

      protected virtual bool IsOver() => Value < 10;
   }
   
   
}