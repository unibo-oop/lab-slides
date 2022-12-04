using System;
using Pairs;

namespace ListWithMethod
{
   class UseGenericList
   {
      static void Main(string[] args)
      {
         var strings = GenericList<string>.FromArray(new string[] {"a", "b", "c"});
         var numbers = GenericList<int>.FromArray(new int[] {10,20,30});
         Console.WriteLine(strings.Zip(numbers));
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

      public GenericList<Pair<T,T2>> Zip<T2>(GenericList<T2> list)
      {
         if (list == null) return null;
         return new GenericList<Pair<T, T2>>(
            new Pair<T, T2>(Head, list.Head),
            Tail?.Zip<T2>(list?.Tail));
      }

      public static GenericList<T> FromArray(T[] array)
      {
         GenericList<T> list = null;
         for (var i = array.Length - 1; i >= 0; i--) 
            list = new GenericList<T>(array[i], list);
         return list;
      }

      public override string ToString()
      {
         var s = "[";
         for (var i = 0; i < Length; i++)
            s += this[i] + (i < Length - 1 ? "," : "");
         return s + "]";
      }
   }
}