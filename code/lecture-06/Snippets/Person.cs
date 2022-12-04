using System;

namespace Snippets
{
    public class Person
    {
        private int _age;
        public Person(string name, int age) { Name = name; Age = age; }
        public string Name { get; set; }
        public int Age
        {
            get => _age;
            set
            {
                if (value < 0) throw new ArgumentException("Negative ages are not allowed");
                _age = value;
            }
        }
    }

    public static class Example2
    {
        public static void Main2(string[] args)
        {
            var person1 = new Person("Giovanni", -1); // ArgumentException
            var person2 = new Person("Mirko", 40);
            person2.Age = -2; // ArgumentException
        }
    }
}