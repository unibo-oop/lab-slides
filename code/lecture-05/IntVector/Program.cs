using System;

namespace IntVector
{
   public class UseIntVectors
   {
      public static void Main(string[] args)
      {
         var fibonacci = new IntVector();
         fibonacci.AddElement(1);
         fibonacci.AddElement(5);
         fibonacci[1] = 1;
         for (var i=2; i< 10; i++)
            fibonacci.AddElement(fibonacci[i-1]+fibonacci[i-2]);
         Console.WriteLine(fibonacci); // [1,1,2,3,5,8,13,21,34,55]
      }
   }

   public class IntVector
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private int[] _elements = new int[InitialCapacity];
      public int Size { get; private set; } = 0;

      public int this[int i]
      {
         get => _elements[i];
         set => _elements[i] = value;
      }

      public void AddElement(int element)
      {
         if (Size == _elements.Length) Expand();
         _elements[Size++] = element;
      }

      private void Expand()
      {
         var old = _elements;
         _elements = new int[old.Length * MultiplicationFactor];
         Array.Copy(old,_elements,Size);
      }

      public override string ToString()
      {
         var s = "[";
         for (var i = 0; i < Size; i++) s += _elements[i] + (i < Size - 1 ? ", " : "");
         return s + "]";
      }
   }
}