using System;
using System.Collections.Generic;

namespace VarianceProblem
{
   class Program
   {
      static void Main(string[] args)
      {
         var list = new List<string>(new[] {"10", "20", "30"});
         // AddAString(list,-1); // This code should not work, otherwise...
         String s = list[list.Count - 1];
      }

      public static void AddAnElement(List<object> list, object last)
      {
         list.Add(last);
      }
   }
}