using System;

namespace IntVectorPre
{
   public class UseIntVectors
   {
      public static void Main(string[] args)
      {
         var fibonacci = new IntVector(); 
         Console.WriteLine(fibonacci); // []
         fibonacci.AddElement(1);
         fibonacci.AddElement(5);
         Console.WriteLine(fibonacci); // [1,5]
         fibonacci.SetElementAt(1,1);
         Console.WriteLine(fibonacci); // [1,1]
         for (var i=2; i< 10; i++)
            fibonacci.AddElement(fibonacci.GetElementAt(i-1)+
                                 fibonacci.GetElementAt(i-2));
         Console.WriteLine(fibonacci); // [1,1,2,3,5,8,13,21,34,55]
      }
   }

   public class IntVector
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private int[] _elements = new int[InitialCapacity];
      public int Size { get; private set; } = 0;

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

      public int GetElementAt(int position) => _elements[position];

      public void SetElementAt(int position, int element) => _elements[position] = element;

      public override string ToString()
      {
         var s = "[";
         for (var i = 0; i < Size; i++) s += _elements[i] + (i < Size - 1 ? "," : "");
         return s + "]";
      }
   }
}