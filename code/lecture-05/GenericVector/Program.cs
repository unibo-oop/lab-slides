using System;

namespace GenericVectors
{
   public class UseVectors
   {
      public static void Main(string[] args)
      {
         // we have an explicit type used to store strings...
         // no annoying "as" operator and nulls to deal with
         GenericVector<string> strings = new GenericVector<string>();
         strings.AddElement("hello");
         strings.AddElement("world!");
         string first = strings[0];
         string second = strings[1];
         Console.WriteLine(strings[0].Substring(2)); // "llo" 
         // strings.AddElement(DateTime.Now); // would not compile!
         
         
         var fibonacci = new GenericVector<int>();
         fibonacci.AddElement(1); // actually adding a int, not an int?
         fibonacci.AddElement(5);
         fibonacci[1] = 1;
         for (var i = 2; i < 10; i++)
         {
            fibonacci.AddElement(fibonacci[i-2]+fibonacci[i-1]);
         }
         Console.WriteLine(fibonacci); // [1,1,2,3,5,8,13,21,34,55]

      }
   }

   public class GenericVector<T>
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private T[] _elements = new T[InitialCapacity];
      public int Size { get; private set; } = 0;

      public T this[int i]
      {
         get => _elements[i];
         set => _elements[i] = value;
      }

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

      public override string ToString()
      {
         var s = "[";
         for (var i = 0; i < Size; i++) s += _elements[i] + (i < Size - 1 ? "," : "");
         return s + "]";
      }
   }
}