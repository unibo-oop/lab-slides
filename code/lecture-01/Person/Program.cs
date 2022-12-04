using System;

namespace Person
{
   public class UsePerson
   {
      static void Main(string[] args)
      {
         var p1 = new Person("John", 1980);
         var p2 = new Person("Michael", 1973);
         p2.GotMarried();
         Console.WriteLine(p1.ShowAsString()); // John 1980 False
         Console.WriteLine(p2.ShowAsString()); // Michael 1973 True
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
      public void GotMarried()
      {
         _married = true;
      }
      public string ShowAsString()
      {
         return _name + " " + _birthYear + " " + _married;
      }
   }
}