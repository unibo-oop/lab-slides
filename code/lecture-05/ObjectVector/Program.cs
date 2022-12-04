using System;

namespace ObjectVector
{
   public class UseObjectVectors
   {
      public static void Main(string[] args)
      {
         // used to store strings... needs annoying "as" operator to retrieve
         var strings = new ObjectVector();
         strings.AddElement("hello");
         strings.AddElement("world!");
         string first = strings[0] as string; // could be null
         string second = strings[1] as string;
         Console.WriteLine(first?.Substring(2)); // "llo" 
         // cannot guarantee it contains just strings
         strings.AddElement(DateTime.Now);
         
         
         var fibonacci = new ObjectVector();
         fibonacci.AddElement(1); // actually adding a int?
         fibonacci.AddElement(5);
         fibonacci[1] = 1;
         for (var i = 2; i < 10; i++)
         {
            // working with int? is not very optimal, it's "viscose"
            var next = (fibonacci[i - 1] as int?) + (fibonacci[i - 2] as int?);
            if (next!=null) fibonacci.AddElement(next);
         }
         Console.WriteLine(fibonacci); // [1,1,2,3,5,8,13,21,34,55]
      }
   }

   public class ObjectVector
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private object[] _elements = new object[InitialCapacity];
      public int Size { get; private set; } = 0;

      public object this[int i]
      {
         get => _elements[i];
         set => _elements[i] = value;
      }

      public void AddElement(object element)
      {
         if (Size == _elements.Length) Expand();
         _elements[Size++] = element;
      }

      private void Expand()
      {
         var old = _elements;
         _elements = new object[old.Length * MultiplicationFactor];
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