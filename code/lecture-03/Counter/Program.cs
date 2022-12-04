using System;

namespace Counter
{
   public class UseCounter
   {
      public static void Main(string[] args)
      {
         var counter = new Counter();
         Console.WriteLine(counter.GetValue()); // 0
         counter.Increment();
         counter.Increment();
         counter.Increment();
         Console.WriteLine(counter.GetValue()); // 3
      }
   }

   public class Counter
   {
      // the field is made inaccessible
      private int _countValue;

      // it is the constructor that initialises fields
      public Counter()
      {
         _countValue = 0;
      }

      // the only method to observe state
      public int GetValue()
      {
         return _countValue;
      }

      // the only method to modify state
      public void Increment()
      {
         _countValue++;
      }
   }

   public class CounterHelper
   {
      public static int CountElements(int[] array, int elem)
      {
         var counter = new Counter(); // instead of 'int counter = 0' 
         foreach (var t in array)
         {
            if (t == elem)
            {
               counter.Increment(); // instead of 'counter++'
            }
         }
         return counter.GetValue(); // instead of 'return counter'
      }
   }
   
   public class CounterHelper2
   {
      public static int CountElements(int[] array, int elem)
      {
         var counter = new Counter(); // instead of 'int counter = 0' 
         for (var index = 0; index < array.Length; index++)
         {
            var t = array[index];
            if (t == elem)
            {
               counter.Increment(); // instead of 'counter++'
            }
         }

         return counter.GetValue(); // instead of 'return counter'
      }
   }
   
   
}