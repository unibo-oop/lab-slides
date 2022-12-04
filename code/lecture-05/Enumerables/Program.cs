using System;
using System.Collections;
using System.Collections.Generic;

namespace Enumerables
{
   class Program
   {
      static void Main(string[] args)
      {
         UseEnumerator.TestEnumerator();
         Console.WriteLine("");
         Console.WriteLine("---");
         UseEnumerables.TestEnumerable();
         Console.WriteLine("");
         Console.WriteLine("---");
         TestForeach();
      }
      
      static void TestForeach()
      {
         var range = new Range(); // default construction
         range.Start = 0;
         range.Stop = 5;
         foreach (var i in range){
            Console.Write(i+" ");
         }
         // note that foreach also calls Dispose
         Console.WriteLine("");
         
         // using object initializer
         foreach (var i in new Range{ Start = 0, Stop = 5}){
            Console.Write(i+" ");
         }
      }
   }
}