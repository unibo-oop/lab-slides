using System;
using System.Collections;
using System.Collections.Generic;
using Pairs;

namespace VariantVector
{
   public interface IBaseVector
   {
      int Size { get;}
   }

   public interface IReadVector<out T> : IBaseVector, IEnumerable<T> 
   {
      T this[int i] { get; }
   }

   public interface IWriteVector<in T> 
   {
      void AddElement(T t);
   }

   public interface IVector<T> : IReadVector<T>, IWriteVector<T>
   {
   }

   public class GenericVector<T>: IVector<T>
   {
      private const int InitialCapacity = 10;
      private const int MultiplicationFactor = 2;
      private T[] _elements = new T[InitialCapacity];
      public int Size { get; private set; } = 0;

      public T this[int i] => _elements[i];
      

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

      public IEnumerator<T> GetEnumerator()
      {
         for (var i = 0; i < Size; i++) yield return _elements[i];
      }

      IEnumerator IEnumerable.GetEnumerator() => GetEnumerator();
   }
   
   class Program
   {
      static void Main(string[] args)
      {
         IVector<string> vs = new GenericVector<string>();
         AddManyStrings(vs, 5);
         IVector<object> vo = new GenericVector<object>();
         AddManyStrings(vo, 5); // IWriteVector<object> <: IWriteVector<string>
         IVector<Pair<string, string>> vp = new GenericVector<Pair<string, string>>();
         vp.AddElement(new Pair<string, string>("a","b"));
         Copy(vs, vo); // same as Copy<object>(vs, vo), or even Copy<string>(vs, vo)
         Copy(vp, vo); // IReadVector<Pair<string,string>> <: IReadVector<object>
         foreach (var o in vo) Console.WriteLine(o);
      }

      public static void AddManyStrings(IWriteVector<string> vector, int n)
      {
         for (int i=0; i<n; i++) vector.AddElement(""+i);
      }

      public static void Copy<T>(IReadVector<T> from, IWriteVector<T> to)
      {
         foreach(var t in from) to.AddElement(t);
      }
   }
   
   
}