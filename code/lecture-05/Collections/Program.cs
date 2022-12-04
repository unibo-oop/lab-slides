using System;
using System.Collections.Generic;

namespace Collections
{
   public class ShowCollections
   {
      public static void Main(string[] args)
      {
         // IList and List are from System.Collections.Generic
         
         IList<int> fibonacci = new List<int>();
         fibonacci.Add(1);
         fibonacci.Add(1);
         for (var i = 2; i < 10; i++)
         {
            fibonacci.Add(fibonacci[i-2]+fibonacci[i-1]);
         }

         foreach (var i in fibonacci) Console.WriteLine(i);
      }
   }
}