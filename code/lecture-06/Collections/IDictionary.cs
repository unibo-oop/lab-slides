using System.Collections;
using System.Collections.Generic;

namespace Collections
{
    // A collection containing a number of key-value pairs
    // where keys are of type K (and cannot be null) and values are of type V
    public interface IDictionary<K, V> : ICollection<KeyValuePair<K, V>> where K : notnull
    {
        // Gets or sets the element with the specified key
        V this[K key] { get; set; }

        // Returns a collection containing all the keys used in the current dictionary
        ICollection<K> Keys { get; }

        // Returns a collection containing all the values used in the current dictionary
        ICollection<V> Values { get; }

        // Adds a new key-value pair. Throws an exception if key is already present 
        void Add(K key, V value);

        // Returns true if a pair indexed by key is present, false otherwise
        bool ContainsKey(K key);

        // Removes a key and its corresponding pair. Returns null if the key is missing
        bool Remove(K key);
        
        // RECALL THAT METHODS FROM Object, ICollection<T>, and IEnumerable<T> ARE INHERITED!
    }
}