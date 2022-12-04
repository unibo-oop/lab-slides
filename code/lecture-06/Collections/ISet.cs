using System.Collections;
using System.Collections.Generic;

namespace Collections
{
    // Collection storing items with no duplicates, regardless of their ordering
    public interface ISet<T> : ICollection<T>, IEnumerable<T>, IEnumerable
    {
        // Adds an item to the set, returning false if it was already present, true otherwise
        bool Add(T item);

        // Removes all elements in the enumerable from the current set
        void ExceptWith(IEnumerable<T> other);

        // Modifies the current set so that it contains only elements
        // that are contained in both the current set and the provided enumerable
        void IntersectWith(IEnumerable<T> other);

        // Returns true if all the items of the set are contained in the enumerable,
        // and the enumerable contains other items as well
        bool IsProperSubsetOf(IEnumerable<T> other);

        // Returns true if all the items of the enumerable are contained in current set,
        // and the current set contains other items as well
        bool IsProperSupersetOf(IEnumerable<T> other);

        // Returns true if all the items of the set are contained in the enumerable
        bool IsSubsetOf(IEnumerable<T> other);

        // Returns true if all the items of the enumerable are contained in current set
        bool IsSupersetOf(IEnumerable<T> other);

        // Returns true if some item of the current set is in the enumerable as well
        bool Overlaps(IEnumerable<T> other);

        // Returns true if the current set and the specified collection contain the same elements
        bool SetEquals(IEnumerable<T> other);

        // Modifies the current set so that it contains only those items that
        // are present either in the current set or in the enumerable, but not both
        void SymmetricExceptWith(IEnumerable<T> other);

        // Modifies the current set so that it contains both its original items and the ones
        // in the provided enumerable, without repetitions
        void UnionWith(IEnumerable<T> other);
        
        // RECALL THAT METHODS FROM Object, ICollection<T>, and IEnumerable<T> ARE INHERITED!
    }
}