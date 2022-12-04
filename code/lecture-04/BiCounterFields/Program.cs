using System;

namespace BiCounterFields
{
   class UseBiCounter
   {
      public static void Main(string[] args)
      {
         var counter = new BiCounter(5);
         Console.WriteLine(counter.GetValue()); // 5
         counter.Increment();
         counter.Decrement();
         counter.Decrement();
         Console.WriteLine(counter.GetValue()); // 4
      }
   }

   public class ExtendibleCounter
   {
      private int _value;
      
      public ExtendibleCounter(int initialValue) => _value = initialValue;

      public int GetValue() => _value;

      protected void SetValue(int value) => _value = value;
    
      public void Increment() => _value++;
   }

   public class BiCounter : ExtendibleCounter
   {
      public BiCounter(int initialValue) : base(initialValue)
      {
      }

      public void Decrement() => SetValue(GetValue()-1);
   }
}