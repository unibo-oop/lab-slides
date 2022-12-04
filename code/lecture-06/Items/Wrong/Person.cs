using System;

namespace Items.Wrong
{
    public class Person
    {
        public Person(string firstName, string lastName, int age)
        {
            FirstName = firstName;
            LastName = lastName;
            Age = age;
        }

        public string FirstName { get; }
        public string LastName { get; }
        public int Age { get; }
    }

    public static class Program
    {
        public static void Example()
        {
            var person1 = new Person("Giovanni", "Ciatto", 29);
            var person2 = new Person("Giovanni", "Ciatto", 29);
            
            Console.WriteLine(person1 == person2); // false
            Console.WriteLine(person1.Equals(person2)); // false
        }
    }
}