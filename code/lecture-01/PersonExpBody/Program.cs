using System;

namespace PersonExpBody
{
   public class UsePerson
   {
      public static void Main(string[] args)
      {
         var p1 = new Person("John", 1980);
         Console.WriteLine(p1.GetName());
         Console.WriteLine(p1.GetBirthYear());
         Console.WriteLine(p1.GetMarried());
         Console.WriteLine(p1.GetStringRepresentation());
         p1.SetMarried(true);
         Console.WriteLine(p1.GetMarried());
      }
   }
   public class Person
   {
      private readonly string _name;   // readonly field, cannot be changed
      private readonly int _birthYear; // readonly field, cannot be changed
      private bool _married = false;
      
      public Person(string name, int birthYear)
      {
         _name = name;
         _birthYear = birthYear;
      }

      public string GetName() => _name;
      
      public int GetBirthYear() => _birthYear;
      
      public bool GetMarried() => _married;
      
      public void SetMarried(bool married) => _married = married;
      
      public string GetStringRepresentation() => _name + " " + _birthYear;
   }
}