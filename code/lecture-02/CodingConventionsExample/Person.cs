using System;

namespace CodingConventionsExample
{
    /// <summary>
    /// Correct version of Persona
    /// </summary>
    public class Person
    {
        private readonly string _name;
        
        private readonly string _surname;
        
        private readonly int _age;

        public string FullName => _name + _surname;

        public int Age => _age;

        public string Surname => _surname;

        public override string ToString() => $"Person(full name: {FullName}, age: {Age})";

        public static void Main2(string[] args) // cannot call this method `Main` as there can only be one Main per project 
        {
            var person = new Person();
            string fullName = person.FullName;
            Console.WriteLine(person.ToString());
        }
    }
}