using System;
using System.Collections;
using System.Collections.Generic;

namespace EnumerableVector
{
   public class UseEnumerableVectors
   {
      public static void Main(string[] args)
      {
         var fibonacci = new EnumerableVector<int>();
         fibonacci.AddElement(1);
         fibonacci.AddElement(1);
         for (var i = 2; i < 10; i++)
         {
            fibonacci.AddElement(fibonacci[i-2]+fibonacci[i-1]);
         }

         foreach (var i in fibonacci) Console.WriteLine(i);
      }
   }

   public class EnumerableVector<T> : IEnumerable<T>
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private T[] _elements = new T[InitialCapacity];
      public int Size { get; private set; } = 0;
      public T this[int i] => _elements[i];

      public void AddElement(T element)
      {
         if (Size == _elements.Length) Expand();
         _elements[Size++] = element;
      }

      private void Expand()
      {
         var old = _elements;
         _elements = new T[old.Length * MultiplicationFactor];
         Array.Copy(old,_elements,Size);
      }

      public IEnumerator<T> GetEnumerator()
      {
         for (var i = 0; i < Size; i++) yield return _elements[i];
      }
      
      IEnumerator IEnumerable.GetEnumerator() => GetEnumerator();
   }
}