using System;
using System.Data;

namespace Aula
{
   class Program
   {
      public static void Main(string[] args)
      {
         // used to store strings... needs annoying "as" operator to retrieve
         var strings = new GenericCollection<string>();
         strings.AddElement("hello");
         strings.AddElement("world!");

         Console.WriteLine(strings[0].Substring(2)); 
         // cannot guarantee it contains just strings
         //strings.AddElement(DateTime.Now);
         
         
         var fibonacci = new GenericCollection<int>();
         fibonacci.AddElement(1); // actually adding a int?
         fibonacci.AddElement(5);
         fibonacci[1] = 1;
         for (var i = 2; i < 10; i++)
         {
            // boilerplate code!
            // working with int? is not very optimal, it's "viscose"
            fibonacci.AddElement(fibonacci[i-1]+fibonacci[i-2]);
         }
         ShowAll<int>(fibonacci); // [1,1,2,3,5,8,13,21,34,55]
         ShowAll<string>(strings); // [1,1,2,3,5,8,13,21,34,55]

         ICollection<string> coll = new GenericCollection<string>();
         ICollection<string> coll2 = new GenericList<string>();
      }

      static public void ShowAll<T>(GenericCollection<T> collection)
      {
         for (int i = 0; i < collection.Size; i++)
         {
            Console.Write(collection[i]+",");
         }
         Console.WriteLine();
      }
   }

   interface ICollection<T>
   {
      int Size { get; }
      void AddElement(T e);
      T this[int index] { get; set; }
   }

   class GenericCollection<T> : ICollection<T> {
      private T[] _elements = new T[10];
      public int Size { get; private set; }

      public T this[int index]
      {
         get => _elements[index];
         set => _elements[index] = value;
      }
      
      public void AddElement(T e)
      {
         if (Size == _elements.Length) Expand();
         _elements[Size] = e;
         Size++;
      }

      private void Expand()
      {
         var newArray = new T[Size * 2];
         for (int i = 0; i < Size; i++)
         {
            newArray[i] = _elements[i];
         }
         _elements = newArray;
      }

      public override string ToString()
      {
         var str = "{";
         for (int i = 0; i < Size-1; i++)
         {
            str = str + _elements[i] + ",";
         }
         return str + _elements[Size-1] + "}";
      }

   }
}