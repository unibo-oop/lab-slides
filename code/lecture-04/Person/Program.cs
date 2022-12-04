using System;

namespace Persons
{
   public class UsePerson
   {
      public static void Main(string[] args)
      {
         var people = new Person[]
         {
            new Teacher("Mirko", 521, new string[] {"oop", "softeng"}),
            new Student("Mario", 1001, 2019),
            new Student("Carla", 1002, 2020),
            new Teacher("Giovanni", 522, new string[] {"sistdist"})
         };
         // note the polymorphic call to virtual method ToString...
         foreach (var person in people)
         {
            Console.WriteLine($"{person.Name}; {person.ToString()}");
         }
      }
   }
   public class Person
   {
      public string Name { get; }
      
      public int Id { get; }

      public Person(string name, int id)
      {
         Name = name;
         Id = id;
      }
   }

   public class Student : Person
   {
      public int MatriculationYear { get; }

      public Student(string name, int id, int matriculationYear) : base(name, id)
      {
         MatriculationYear = matriculationYear;
      }

      public override string ToString() => $"S[{Name}, {Id}, m:{MatriculationYear}]";
   }

   public class Teacher : Person
   {
      public string[] Courses { get; }

      public Teacher(string name, int id, string[] courses) : base(name, id)
      {
         Courses = courses;
      }
      
      public override string ToString() => $"T[{Name}, {Id}, c:{string.Join(",",Courses)}]";
   }
}