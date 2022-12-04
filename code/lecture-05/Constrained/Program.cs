using System;
using System.Collections;
using System.Collections.Generic;

namespace Constrained
{
   class Program
   {
      static void Main(string[] args)
      {
         ShowAll(Create<object>(5));
         ShowAll(Create<DateTime>(5));
         // ShowAll(Create<IList>(5)); // would notwork!
         
         var list1 = new List<object>(new object[]{1, true, new DateTime()});
         var list2 = new List<int>(new int[]{1, 2,3,4,5});
         Copy(list2, list1);
         ShowAll(list1);
         // Copy(list1, list2); // would not work!
      }

      public static void ShowAll<T>(IEnumerable<T> enumerable)
      {
         foreach(var t in enumerable) Console.Write(t+" ");
         Console.WriteLine();
      }

      public static List<T> Create<T>(int size) where T: new()
      {
         var l = new List<T>();
         for (var i=0; i<10; i++) l.Add(new T());
         return l;
      }
      
      public static void Copy<TFrom,TTo>(List<TFrom> from, List<TTo> to) where TFrom: TTo
      {
         foreach (var t in from) to.Add(t);
      }
   }
}