namespace Collections
{
    public class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public override string ToString() => 
            $"{nameof(Person)}({nameof(Name)}: {Name}, {nameof(Age)}: {Age})";
    }
}