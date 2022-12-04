using System;

namespace Items
{
    class Object
    {
        // Returns true if this is equal to obj
        // (according to some notion of equality which makes sense for the current type)
        public bool Equals(object? obj) { /* ... */ }

        // Returns a number which is the same for all objects which are equal
        public int GetHashCode() { /* ... */ }
        
        // Returns an intelligible representation of the object as a string
        public string ToString() { /* ... */ }
    }
}