using System;

namespace IGenericCollection
{
   public class UseIGenericVectors
   {
      public static void Main(string[] args)
      {
         // Note use of interface as type, class as implementation
         IGenericVector<string> strings = new GenericVector<string>();
         strings.AddElement("hello");
         strings.AddElement("world!");
         string first = strings[0];
         string second = strings[1];
         Console.WriteLine(strings.Size); // 2 
         Console.WriteLine(strings[0].Substring(2)); // "llo" 
      }
   }

   public interface IGenericVector<T>
   {
      int Size { get; }
      
      T this[int i] { get; set; }

      void AddElement(T element);
   }

   public class GenericVector<T> : IGenericVector<T>
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