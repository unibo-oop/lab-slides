namespace Collections
{
    // A type for IMMUTABLE triplets of items where the 1st one is of type T1,
    // the 2nd one is of type T2, and the 3rd one is of type T3 
    public class Tuple<T1, T2, T3>
    {
        private readonly object[] _items;

        public Tuple(T1 x, T2 y, T3 z) { _items = new object[] {x, y, z}; }
        
        public T1 Item1 => (T1) _items[0]; // Gets the first item
        public T2 Item2 => (T2) _items[1]; // Gets the second item
        public T3 Item3 => (T3) _items[2]; // Gets the third item

        public object this[int index] => _items[index];
        
        int Length => _items.Length;
        
        // method Equals compares triplets by value
        // method GetHashCode is coherent w.r.t. equals
        
        // method ToString prints the items
    }

    // Static class for initialising tuples
    public static class Tuple
    {
        // factory methods for tuples of 1-8 items are present, e.g.:
        
        public static Tuple<T1, T2, T3> Create<T1, T2, T3>(T1 item1, T2 item2, T3 item3)
        {
            return new Tuple<T1, T2, T3>(item1, item2, item3);
        }
    }
}