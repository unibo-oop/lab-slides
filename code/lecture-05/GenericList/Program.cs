using System;

namespace GenericLists
{
   class UseGenericList
   {
      static void Main(string[] args)
      {
         var strings = 
            new GenericList<string>("Hello!", 
               new GenericList<string>("my",
                  new GenericList<string>("World", null)));
         Console.WriteLine(strings.Head+ " " + strings.Tail);
         Console.WriteLine(strings); // [Hello!,my,World]
         
         // no problems as those with the "monomorphic collection" mechanisms
         var numbers =
            new GenericList<int>(10, new GenericList<int>(20, null));
         int sum = numbers.Head + numbers.Tail.Head;
         Console.WriteLine(sum);
      }
   }

   public class GenericList<T>
   {
      public T Head { get; }
      public GenericList<T> Tail { get; }

      public GenericList(T head, GenericList<T> tail)
      {
         Head = head;
         Tail = tail;
      }

      public T this[int i] => i == 0 ? Head : Tail[i - 1]; 

      public int Length => 1 + (Tail?.Length ?? 0);

      public override string ToString()
      {
         var s = "[";
         for (var i = 0; i < Length; i++)
            s += this[i] + (i < Length - 1 ? "," : "");
         return s + "]";
      }
   }
}