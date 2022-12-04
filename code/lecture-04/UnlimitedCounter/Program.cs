using System;

namespace InfiniteDevice
{
   public class Counter
   {
      public int Value { get; private set; } = 0;

      public virtual void Increment() => Value++;
   }

   public class LimitCounter : Counter
   {
      private int _limit;

      public LimitCounter(int limit) => _limit = limit;

      public virtual int ToLimit => _limit - Value;

      public virtual bool IsOver => ToLimit == 0;

      public override void Increment()
      {
         if (!IsOver) base.Increment();
      }
   }

   public class UnlimitedCounter : LimitCounter
   {
      public UnlimitedCounter(int limit) : base(Int32.MaxValue)
      {
      }

      public override int ToLimit => Int32.MaxValue;
   }

   class Program
   {
      static void Main(string[] args)
      {
         Console.WriteLine("Hello World!");
      }
   }
}