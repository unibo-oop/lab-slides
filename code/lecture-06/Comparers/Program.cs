using System;
using System.Collections.Generic;
using Collections;

namespace Comparers
{
    class Program
    {
        static void Main(string[] args)
        {
            var people = new List<Person>() {
                new Person() {Name = "Matteo", Age = 29},
                new Person() {Name = "Giovanni", Age = 29},
                new Person() {Name = "Mirko", Age = 45},
                new Person() {Name = "Andrea", Age = 50}
            };
            
            people.Sort(new PersonComparerByAge());
            Console.WriteLine(string.Join(", ", people)); // matteo, giovanni, mirko, andrea
            
            people.Sort(new PersonComparerByName());
            Console.WriteLine(string.Join(", ", people)); // andrea, giovanni, matteo, mirko
            
            people.Sort(new PersonComparerByAgeAndName());
            Console.WriteLine(string.Join(", ", people)); // andrea, mirko, giovanni, matteo
        }
    }
}