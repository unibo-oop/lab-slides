using System;

namespace PersonProperties
{
   public class UsePerson
   {
      public static void Main(string[] args)
      {
         var p1 = new Person("John", 1980);
         Console.WriteLine(p1.Name);
         Console.WriteLine(p1.BirthYear);
         Console.WriteLine(p1.Married);
         Console.WriteLine(p1.StringRepresentation);
         p1.Married = true;
         Console.WriteLine(p1.Married);
      }
   }
   public class Person
   {
      public string Name { get; }    // auto-implemented readonly property
      public int BirthYear { get;  } // auto-implemented readonly property
      public bool Married { get; set; } // auto-implemented read/write property

      public Person(string name, int birthYear)
      {
         Name = name;
         BirthYear = birthYear;
         Married = false;
      }
      
      // expression-bodied property
      public string StringRepresentation => Name + " " + BirthYear;  
   }
}
