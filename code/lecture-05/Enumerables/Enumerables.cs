using System;
using System.Collections;
using System.Collections.Generic;

namespace Enumerables
{
   class UseEnumerables
   {
      public static void TestEnumerable()
      {
         IEnumerable<int> range = new Range{ Start = 0, Stop = 5};
         var enumerator = range.GetEnumerator();
         while (enumerator.MoveNext())
         {
            Console.Write(enumerator.Current+" ");
         }
         enumerator.Dispose();
         Console.WriteLine();
         
         var enumerator2 = range.GetEnumerator();
         while (enumerator2.MoveNext())
         {
            if (enumerator2.Current > 2)
            {
               Console.Write(enumerator2.Current+" ");
            }
         }
         enumerator2.Dispose();
      }
   }

   public class Range : IEnumerable<int>
   {
      public int Start {get; set; }
      public int Stop {get; set; }
      
      public IEnumerator<int> GetEnumerator() => 
         new RangeEnumerator(Start, Stop);
      
      // a "dirty" method, due to IEnumerable non-generic superinterface 
      IEnumerator IEnumerable.GetEnumerator() => 
         GetEnumerator();
   }
}