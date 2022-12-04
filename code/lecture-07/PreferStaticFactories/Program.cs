using System;

namespace PreferStaticFactories
{
   class Person
   {
      public string Name { get; private set; }
      public int Year { get; private set; }
      public bool Married { get; set; }

      private Person()
      {
      }

      public static Person Create(string name, int year, bool married) => new Person()
      {
         Name = name,
         Year = year,
         Married = married
      };
   }

   class Program
   {
      static void Main(string[] args)
      {
         var person = Person.Create("Mario", 1970, false);
         /* Advantages:
          * - clearer name of the method
          * - no constructor/method duality in APIs
          * - the factory could instantiate a subclass
          * - the factory could choose the proper implementation
          * - the factory part could be moved behind an interface
          */
      }
   }
}