using System;

namespace Indexers
{
    class SomeIndex {}
    
    class SomeOtherIndex{}

    class ItemType {}
    
    class SomeContainer
    {
        public ItemType this[SomeIndex key1, SomeOtherIndex key2]
        {
            get
            {
                // compute/search some ItemType using key1 and key2
                return // an instance of ItemType
            }
            set
            {
                // store value using key1 and key2
            }
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            var container = new SomeContainer();
            SomeIndex key1 = new SomeIndex(/* ... */);
            SomeOtherIndex key2 = new SomeOtherIndex(/* ... */);

            // reading an item calls the getter
            ItemType item = container[key1, key2];
            
            // assigning an item calls the setter
            container[key1, key2] = new ItemType(/* ... */);
        }
    }
}