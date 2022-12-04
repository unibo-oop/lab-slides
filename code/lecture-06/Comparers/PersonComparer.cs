using System.Collections.Generic;

namespace Collections
{
    // Orders persons by age (young to old)
    public class PersonComparerByAge : IComparer<Person>
    {
        public int Compare(Person x, Person y) => x.Age - y.Age;
    }
    
    // Orders persons by name, lexicographically
    public class PersonComparerByName : IComparer<Person>
    {
        public int Compare(Person x, Person y) => string.Compare(x.Name, y.Name);
    }
    
    // Orders persons by age (old to young), and, in case of equal age, by name
    public class PersonComparerByAgeAndName : IComparer<Person>
    {
        public int Compare(Person x, Person y)
        {
            if (x.Age == y.Age)
            {
                return string.Compare(x.Name, y.Name);
            }
            else
            {
                return y.Age - x.Age;
            }
        }
    }
}