using System;

namespace CounterProperties
{
   public class UseCounter
   {
      public static void Main(string[] args)
      {
         var counter = new Counter();
         Console.WriteLine(counter.Value); // 0
         counter.Increment();
         counter.Increment();
         Console.WriteLine(counter.Value); // 2
      }
   }
   
   public class Counter
   {
      // an implicitly define field, not modifiable from outside
      // still a well encapsulated solution: one can change implementation
      // of get and set below if needed
      public int Value { get; private set; } = 0;

      public void Increment() => Value++;
   }
}
namespace CounterChanged{
   public class Counter
   {
      // a modified implementation, without required changes in clients
      private int _value;
      private const int MaxValue = 100; // const: essentially a MACRO

      // note the property Value ensures MaxValue is never overcame 
      public int Value
      {
         get => _value; 
         private set => _value = value<=MaxValue ? value : _value;
      }

      public Counter()
      {
         Value = 0;
      }

      public void Increment() => Value++;
   }
}