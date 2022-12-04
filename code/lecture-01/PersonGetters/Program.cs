using System;

namespace PersonGetters
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
      private string _name;  // string is an alias for String...
      private int _birthYear;
      private bool _married = false;
      public Person(string name, int birthYear)
      {
         _name = name;
         _birthYear = birthYear;
      }
      public string GetName()
      {
         return _name;
      }
      public int GetBirthYear()
      {
         return _birthYear;
      }
      public bool GetMarried()
      {
         return _married;
      }
      public void SetMarried(bool married)
      {
         _married = married;
      }
      public string GetStringRepresentation()
      {
         return _name + " " + _birthYear;
      }
   }
}