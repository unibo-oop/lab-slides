using System;
using System.Collections.Generic;

namespace Enumerables
{
    // Any container of items which can be enumerated
    public interface IEnumerable<T>
    {
        // Creates a novel enumerator for enumerating the items of this enumerable
        IEnumerator<T> GetEnumerator();
    }
    
    // Any object capable of enumerating an enumerable
    public interface IEnumerator<out T>
    {
        // Moves the enumeration forward, returning false if it is over, true otherwise
        bool MoveNext();
        
        // Returns the current item
        T Current { get; }
        
        // Restarts the enumeration
        void Reset();
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            
        }
    }
}