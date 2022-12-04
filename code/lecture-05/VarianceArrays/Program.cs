using System;

namespace VarianceArrays
{
   class Program
   {
      static void Main(string[] args)
      {
         string[] s = new[] {"a", "b", "c"};
         SetToArray(s,10); // It works!
         string str = s[0]; // It throws a: System.ArrayTypeMismatchException:
      }

      public static void SetToArray(object[] array, object element)
      {
         array[0] = element;
      }
   }
}