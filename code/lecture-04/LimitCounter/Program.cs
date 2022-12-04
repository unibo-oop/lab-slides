using System;

namespace LimitCounter
{
   public class UseLimitCounter
   {
      public static void Main(string[] args)
      {
         var limitCounter = new LimitCounter(3);
         Console.WriteLine(limitCounter.Value); // 0
         limitCounter.Increment();
         limitCounter.Increment();
         Console.WriteLine(limitCounter.Value); // 2
         limitCounter.Increment();
         limitCounter.Increment();
         Console.WriteLine(limitCounter.Value); // 3
      }
   }

   public class Counter
   {
      public int Value { get; protected set; }

      public Counter(int initialValue) => Value = initialValue;

      public virtual void Increment() => Value++;
   }

   public sealed class LimitCounter : Counter
   {
      private readonly int _limit;

      public LimitCounter(int limit) : base(0) => _limit = limit;

      public bool IsOver() => Value >= _limit;

      public override void Increment()
      {
         if (!IsOver()) base.Increment();
      }
   }
}