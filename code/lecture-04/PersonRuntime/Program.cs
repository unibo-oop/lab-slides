using System;
using Persons;

namespace PersonRuntime
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
         // printing only teachers
         foreach (var person in people)
         {
            if (person is Teacher) // check for run-time type
            {
               Console.WriteLine($"{person.Name}; {person.ToString()}");
            }
            else
            {
               Student student = person as Student; // type conversion, same reference!
               // Teacher teacher = person as Teacher; // this would yield null! 
               Console.WriteLine($"{student.Name}; {student.MatriculationYear}");
            }
         }
      }
   }
}