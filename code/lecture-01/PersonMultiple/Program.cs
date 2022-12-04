using System;

namespace PersonMultiple
{
   public class UsePerson
   {
      public static void Main(string[] args)
      {
         Console.WriteLine(new Person("Bill").ShowAsString());
         Console.WriteLine(new Person("Michael", 1973, true).ShowAsString());
      }
   }
   public class Person
   {
      private string _name;
      private int _birthYear;
      private bool _married;
      
      public Person(string name)
      {
         _name = name;
         _birthYear = 1900;
         _married = false;
      } 
      public Person(string name, int birthYear, bool married)
      {
         _name = name;
         _birthYear = birthYear;
         _married = married;
      }
      public string ShowAsString()
      {
         return _name + " " + _birthYear + " " + _married;
      }
   }
}