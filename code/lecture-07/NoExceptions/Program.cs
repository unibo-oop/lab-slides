using System;
using System.Collections.Generic;
using System.Linq;

namespace NoExceptions
{
   interface IOption<T>
   {
      T GetOrElse(T def);
      IOption<TResult> Map<TResult>(Func<T,TResult> map);
      
      // Note static factories hiding actual implementation
      static IOption<T> Some(T t) => new SomeOption<T> {Value = t};
      static IOption<T> None() => new NoneOption<T>();

      // Note implementations as private nested classes
      private class SomeOption<T> : IOption<T> 
      {
         public T Value { get; set; }
         public T GetOrElse(T def) => Value;
         public IOption<TRes> Map<TRes>(Func<T, TRes> map) => 
            new SomeOption<TRes>{Value = map(Value)};
      }

      private class NoneOption<T> : IOption<T>
      {
         public T GetOrElse(T def) => def;
         public IOption<TRes> Map<TRes>(Func<T, TRes> map) => IOption<TRes>.None();
      }
   }

   class Program
   {
      // What should we return if the list is empty? -1? Exception? Nah...
      private static IOption<int> Min(List<int> list)
      {
         if (list.Count == 0) IOption<int>.None();
         var min = list[0];
         foreach (var i in list)
            if (i < min)
               min = i;
         return IOption<int>.Some(min);
      }

      static void Main(string[] args)
      {
         var result1 = Min(new List<int>(new[] {10, 30, 40, 20}));
         var result2 = Min(new List<int>());
         Console.WriteLine(result1.Map(i => "Res: "+i).GetOrElse("undefined")); // 10
         Console.WriteLine(result2.Map(i => "Res: "+i).GetOrElse("undefined")); // undef
      }
   }
}