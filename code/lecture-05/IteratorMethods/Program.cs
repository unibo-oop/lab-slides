using System;
using GenericLists;
using GenericVectors;
using Iterators;
using Pairs;

namespace IteratorMethods
{
   class UseIterators
   {
      static void Main(string[] args)
      {
         var rangeIterator1 = new RangeIterator(0, 5);
         ShowAll(rangeIterator1);
         ShowAll(new RangeIterator(0, 7));
         Console.WriteLine(GetLast(new RangeIterator(0, 7)));
         
         var vector = new GenericVector<string>();
         vector.AddElement("hello");
         vector.AddElement("world");
         var rangeIterator2 = new GenericVectorIterator<string>(vector);
         ShowAll(rangeIterator2);

         var list = new GenericList<Pair<int, string>>(
            new Pair<int, string>(10, "20"),null);
         var rangeIterator3 = new GenericListIterator<Pair<int, string>>(list);
         ShowFirstComponent(rangeIterator3);
      }

      public static void ShowAll<T>(IIterator<T> iterator)
      {
         while(iterator.HasNext()) Console.WriteLine(iterator.Next());
      }

      public static T GetLast<T>(IIterator<T> iterator)
      {
         T last = default(T); // null for references, 0 for numbers, false for boolean
         while (iterator.HasNext()) last = iterator.Next();
         return last;
      }

      public static void ShowFirstComponent<TA, TB>(IIterator<Pair<TA, TB>> iterator)
      {
         while(iterator.HasNext()) Console.WriteLine(iterator.Next().First);
      }

   }
}