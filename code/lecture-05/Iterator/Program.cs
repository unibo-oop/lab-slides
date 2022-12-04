using System;
using GenericLists;
using GenericVectors;

namespace Iterators
{
   class UseIterators
   {
      static void Main(string[] args)
      {
         var rangeIterator1 = new RangeIterator(0, 5);
         while (rangeIterator1.HasNext()) Console.WriteLine(rangeIterator1.Next());

         var vector = new GenericVector<string>();
         vector.AddElement("hello");
         vector.AddElement("world");
         var rangeIterator2 = new GenericVectorIterator<string>(vector);
         while (rangeIterator2.HasNext()) Console.WriteLine(rangeIterator2.Next());
         
         var list = new GenericList<DateTime>(DateTime.Now, new GenericList<DateTime>(DateTime.Today, null));
         var rangeIterator3 = new GenericListIterator<DateTime>(list);
         while (rangeIterator3.HasNext()) Console.WriteLine(rangeIterator3.Next());
      }
   }

   public interface IIterator<T>
   {
      T Next();

      bool HasNext();
   }

   public class RangeIterator : IIterator<int>
   {
      private readonly int _stop;
      private int _index;
      
      public RangeIterator(int start, int stop)
      {
         _stop = stop;
         _index = start;
      }

      public int Next() => _index++;

      public bool HasNext() => _index <= _stop;
   }

   public class GenericVectorIterator<T> : IIterator<T>
   {
      private int _index = 0;
      private readonly GenericVector<T> _vector;

      public GenericVectorIterator(GenericVector<T> vector) => _vector = vector;

      public T Next() => _vector[_index++];

      public bool HasNext() => _index < _vector.Size;
   }
   
   public class GenericListIterator<T> : IIterator<T>
   {
      private GenericList<T> _list;

      public GenericListIterator(GenericList<T> list) => _list = list;

      public T Next()
      {
         var result = _list.Head;
         _list = _list.Tail;
         return result;
      }

      public bool HasNext() => _list != null;
   }
   
   
}