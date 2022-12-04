using System.Collections;
using System.Collections.Generic;

namespace Collections
{
    // Generic container of items of type T
    public interface ICollection<T> : IEnumerable<T>, IEnumerable
    {
        // Gets the amount of items in the collection
        int Count { get; }

        // Adds an item to the collection
        void Add(T item);

        // Removes all the items from the collection, emptying it
        void Clear();

        // Checks whether item is contained in the collection or not
        bool Contains(T item);

        // Inserts all the items of the collection into array, starting from arrayIndex
        void CopyTo(T[] array, int arrayIndex);

        // Removes item from the collection
        bool Remove(T item);
        
        // RECALL THAT GetEnumerator() IS INHERITED!
    }
}