using System;

namespace PersonPropertiesPlay
{
   public class UsePerson
   {
      public static void Main(string[] args)
      {
         var p1 = new Person("John", 1980);
         Console.WriteLine(p1.Name);
         Console.WriteLine(p1.BirthYear);
         Console.WriteLine(p1.Married); // false
         p1.Married = true;   // can marry
         Console.WriteLine(p1.Married); // true
         p1.Married = false;   // can't unmarry, message emitted
         Console.WriteLine(p1.Married); // still true
         Console.WriteLine(p1.StringRepresentation);
      }
   }
   public class Person
   {
      public string Name { get; }    // auto-implemented readonly property
      public int BirthYear { get;  } // auto-implemented readonly property

      private bool _married;

      public bool Married
      {
         get => _married;
         set {
            if (_married && !value)
            {
               Console.WriteLine("can't unmarry!!");
            }
            else
            {
               _married = value;
            }
         }
      }

      public Person(string name, int birthYear)
      {
         Name = name;
         BirthYear = birthYear;
         Married = false;
      }
      
      public string StringRepresentation => Name + " " + BirthYear;  
   }
}