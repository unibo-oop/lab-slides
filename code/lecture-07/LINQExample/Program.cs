using System;
using System.Collections.Generic;
using System.Linq;

namespace LINQExample
{
   class Person
   {
      public string Name { get; }
      public string Surname { get; }
      public DateTime Birth { get; }
      public Boolean Married { get; }

      public Person(string name, string surname, DateTime birth, bool married)
      {
         Name = name;
         Surname = surname;
         Birth = birth;
         Married = married;
      }

      public override string ToString()
      {
         return $"Name: {Name}, Surname: {Surname}, Birth: {Birth}, Married: {Married}";
      }
   }

   class Program
   {
      static void Main(string[] args)
      {
         var archive = new List<Person>(new Person[]
         {
            new Person( "Mario", "Rossi", new DateTime(1990, 1, 18), false),
            new Person( "Gino", "Bianchi", new DateTime(1980, 2, 20), false),
            new Person( "Carla", "Neri", new DateTime(1992, 12, 2), true),
            new Person( "Rosa", "Rosa", new DateTime(1970, 3, 1), false),
            new Person( "Italo", "Casadei", new DateTime(1990, 12, 25), true)
         });

         var marriedPeople = archive.FindAll(p => p.Married).Select(p => p.ToString());
         var toShow = string.Join(" /// ", marriedPeople.Select(p => p.ToString()));
         Console.WriteLine(toShow);
         
         // count people born later than 1/1/1990
         Predicate<Person> young = p => p.Birth.CompareTo(new DateTime(1990, 1, 1)) > 0;
         var toShow2 = archive.FindAll(p => young(p)).Count;
          
         Console.WriteLine(toShow2);

         var marriedPeople2 = 
            from person in archive 
            where person.Married select person.ToString();
         Console.WriteLine(string.Join(" /// ",marriedPeople2.Select(p => p.ToString())));

      }
   }
}