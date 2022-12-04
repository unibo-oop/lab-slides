using System.Collections;
using System.Collections.Generic;

namespace Collections
{
    // Collection storing items in an orderly fashion
    // (indexes are 0-based)
    public interface IList<T> : ICollection<T>, IEnumerable<T>, IEnumerable
    {
        // Get or sets the index-th item in the list
        T this[int index] { get; set; }

        // Gets the index of an item in the list, or -1 if missing
        int IndexOf(T item);

        // Adds item in position index (subsequent items are shifted right) 
        void Insert(int index, T item);

        // Removes the item in position index (subsequent items are shifted left)
        void RemoveAt(int index);
        
        // RECALL THAT METHODS FROM Object, ICollection<T>, and IEnumerable<T> ARE INHERITED!
    }
}