using System;

namespace PersonChaining
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
      
      public Person(string name, int birthYear, bool married)
      {
         Console.WriteLine("called first constructor");
         _name = name;
         _birthYear = birthYear;
         _married = married;
      }
      
      public Person(string name) : this(name, 1900, false)
      {
         Console.WriteLine("called second constructor... chaining to the first");
      } 

      public string ShowAsString()
      {
         return _name + " " + _birthYear + " " + _married;
      }
   }
}