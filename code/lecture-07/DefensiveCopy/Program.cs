using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace DefensiveCopy
{
   class Archive
   {
      private List<string> _people = new List<string>();

      public Archive(List<string> initial)
      {  // defensive copy
         foreach(var s in initial) _people.Add(s);
      }

      public void Add(string person) => _people.Add(person);

      // Actually protect myself with readonly-wrapper
      public ReadOnlyCollection<string> GetAll() => _people.AsReadOnly();
   }

   class Program
   {
      static void Main(string[] args)
      {
         var archive = new Archive(new List<string>());
         archive.Add("mario");
         archive.Add("gino");
         archive.Add("carlo");

         var all = archive.GetAll();
         foreach (var s in all) Console.WriteLine(s);

         archive.Add("marta");
         foreach (var s in all) Console.WriteLine(s); //marta here as well
      }
   }
}