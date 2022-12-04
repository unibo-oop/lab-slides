using System;

namespace Items.Correct
{
    public class Person
    {
        // constructor

        public string FirstName { get; } string LastName { get; } int Age { get; }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            var other = obj as Person;
            return string.Equals(FirstName, other.FirstName) 
                   && LastName.Equals(other.LastName) && Age.Equals(other.Age);
        }

        public override int GetHashCode() => HashCode.Combine(FirstName, LastName, Age);
    }

    public static class Program
    {
        public static void Example()
        {
            var person1 = new Person("Giovanni", "Ciatto", 29);
            var person2 = new Person("Giovanni", "Ciatto", 29);
            
            Console.WriteLine(person1 == person2); // false
            Console.WriteLine(person1.Equals(person2)); // true
        }
    }
}