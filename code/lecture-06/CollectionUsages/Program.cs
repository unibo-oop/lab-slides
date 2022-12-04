using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace CollectionUsages
{
    class ExampleItem
    {
        public uint Number { get; }

        public ExampleItem(uint index)
        {
            Number = index;
        }

        protected bool Equals(ExampleItem other) => Number == other.Number;

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((ExampleItem) obj);
        }

        public override int GetHashCode() => (int) Number;

        public override string ToString() => $"{nameof(ExampleItem)}({Number})";
    }
    
    class Program
    {
        public static void UseCollection()
        {
            ICollection<ExampleItem> collection = new Collection<ExampleItem>() {
                new ExampleItem(2),
                new ExampleItem(3),
                new ExampleItem(1),
                new ExampleItem(4)
            };

            Console.WriteLine(collection.Count); // 4
            
            Console.WriteLine(collection.Contains(new ExampleItem(5))); // false
            
            collection.Add(new ExampleItem(5)); // item 5 is added
            Console.WriteLine(collection.Contains(new ExampleItem(5))); // true
            Console.WriteLine(collection.Count); // 5
            
            Console.WriteLine(collection.Contains(new ExampleItem(1))); // true
            collection.Remove(new ExampleItem(1)); // item 1 is removed
            Console.WriteLine(collection.Count); // 4
            Console.WriteLine(collection.Contains(new ExampleItem(1))); // false
            
            foreach (var item in collection)
            {
                Console.WriteLine(item); // 2, 3, 4, 5
            }
            
            Console.WriteLine(collection.ToString()); // ???
        }
        
        public static void UseList()
        {
            IList<ExampleItem> list = new List<ExampleItem>() {
                new ExampleItem(2),
                new ExampleItem(3),
                new ExampleItem(1),
                new ExampleItem(4)
            };

            foreach (var item in list)
            {
                Console.WriteLine(item); // 2, 3, 1, 4
            }
            
            Console.WriteLine(list[1]); // 3
            list[1] = new ExampleItem(5);
            Console.WriteLine(list[1]); // 5
            Console.WriteLine(list[2]); // 1
            
            list.Insert(2, new ExampleItem(6));
            Console.WriteLine(list[2]); // 6
            Console.WriteLine(list[3]); // 1
            
            Console.WriteLine(list.IndexOf(new ExampleItem(1))); // 3
            list.RemoveAt(3); // removing item in position 3, i.e. 1
            Console.WriteLine(list.IndexOf(new ExampleItem(1))); // -1

            Console.WriteLine(list.ToString()); // ???
        }
        
        public static void UseSet()
        {
            ISet<ExampleItem> set = new HashSet<ExampleItem>() {
                new ExampleItem(2), new ExampleItem(3), new ExampleItem(2), 
                new ExampleItem(1), new ExampleItem(2)
            };

            foreach (var item in set) Console.WriteLine(item); // 1, 2, 3 (in some order)
            
            Console.WriteLine(set.Count); // 3
            Console.WriteLine(set.Add(new ExampleItem(3))); // false
            Console.WriteLine(set.Count); // 3
            
            var anotherSet = new HashSet<ExampleItem>() { new ExampleItem(1), new ExampleItem(2) };
            
            Console.WriteLine(set.IsProperSupersetOf(anotherSet)); // true
            Console.WriteLine(anotherSet.IsProperSubsetOf(set)); // true
            anotherSet.Add(new ExampleItem(4));
            Console.WriteLine(set.IsProperSupersetOf(anotherSet)); // false
            Console.WriteLine(anotherSet.IsProperSubsetOf(set)); // false
            Console.WriteLine(set.Overlaps(anotherSet)); // true
            set.UnionWith(anotherSet);
            
            foreach (var item in set) Console.WriteLine(item); // 1, 2, 3, 4 (in some order)

            Console.WriteLine(set.ToString()); // ???
        }
        
        public static void UseDictionary()
        {
            IDictionary<string, ExampleItem> map = new Dictionary<string, ExampleItem>() {
                ["giovanni"] = new ExampleItem(1),
                ["mirko"] = new ExampleItem(2),
                ["andrea"] = new ExampleItem(3)
            };

            foreach (KeyValuePair<string, ExampleItem> item in map)
            {
                Console.WriteLine(item.Key); // giovanni, mirko, andrea
                Console.WriteLine(item.Value); // 1, 2, 3
            }
            
            foreach (var (key, val) in map)
            {
                Console.WriteLine(val); // 1, 2, 3
                Console.WriteLine(key); // giovanni, mirko, andrea
            }

            map["andrea"] = new ExampleItem(0); // here the value of key "andrea" is being replaced
            map.Add("matteo", new ExampleItem(3)); // here a novel key-value pair is being added
            map["danilo"] = new ExampleItem(4); // here a novel key-value pair is being added

            try
            {
                map.Add("matteo", new ExampleItem(4)); // fails as key "matteo" is already present
            }
            catch (ArgumentException e) { /* ignore */ }
            
            Console.WriteLine(map["giovanni"]); // 1
            Console.WriteLine(map["mirko"]); // 2
            Console.WriteLine(map["andrea"]); // 0
            Console.WriteLine(map["matteo"]); // 3
            Console.WriteLine(map["danilo"]); // 4

            foreach (string key in map.Keys)
                Console.WriteLine(key); // giovanni, mirko, andrea, matteo, danilo (in some order)
            foreach (ExampleItem val in map.Values)
                Console.WriteLine(val); // 1, 2, 0, 3, 4 (in some order)

            Console.WriteLine(map.ToString()); // ???
        }

        public static void UseTuples()
        {
            Tuple<string, int> pair = Tuple.Create("giovanni", 29);
            Tuple<string, int, DateTime> triplet = Tuple.Create("mirko", 45, DateTime.Now);

            var number = 30;
            Tuple<string, int> anotherPair = Tuple.Create("giovanni", number - 1);
            Tuple<string, int, DateTime> anotherTriplet = Tuple.Create("mirko", 45, DateTime.Now);
            
            Console.WriteLine(pair.ToString()); // (giovanni, 29)
            Console.WriteLine(anotherPair.ToString()); // (giovanni, 29)
            Console.WriteLine(triplet.ToString()); // (mirko, 45, 19/03/2021 16:33:30)
            Console.WriteLine(anotherTriplet.ToString()); // (mirko, 45, 19/03/2021 16:33:30)

            Console.WriteLine(pair.Equals(anotherPair)); // true
            Console.WriteLine(triplet.Equals(anotherTriplet)); // false ...... WHY? :)
            
            Console.WriteLine(triplet.Item1 == anotherTriplet.Item1); // true
            Console.WriteLine(triplet.Item2 == anotherTriplet.Item2); // true
            Console.WriteLine(triplet.Item3 == anotherTriplet.Item3); // false ...... WHY? :)
        }
        
        static void Main(string[] args)
        {
            UseCollection();
            Console.WriteLine("-------");
            UseList();
            Console.WriteLine("-------");
            UseSet();
            Console.WriteLine("-------");
            UseDictionary();
            Console.WriteLine("-------");
            UseTuples();
        }
    }
}