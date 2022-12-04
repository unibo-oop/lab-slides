using System;
using Microsoft.VisualBasic;

namespace ObjectList
{
   class UseObjetList
   {
      static void Main(string[] args)
      {
         var strings = 
            new ObjectList("Hello!", 
            new ObjectList("my",
               new ObjectList("World", null)));
         Console.WriteLine(strings.Head+ " " + strings.Tail);
         Console.WriteLine(strings); // [Hello!,my,World]
         
         // usual problems with the "monomorphic collection" mechanisms
         var numbers =
            new ObjectList(10, new ObjectList(20, null));
         int? sum = (numbers.Head as int?) + (numbers.Tail.Head as int?);
         Console.WriteLine(sum);
      }
   }

   public class ObjectList
   {
      public object Head { get; }
      public ObjectList Tail { get; }

      public ObjectList(object head, ObjectList tail)
      {
         Head = head;
         Tail = tail;
      }

      public object this[int i]  => i == 0 ? Head : Tail[i - 1];

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