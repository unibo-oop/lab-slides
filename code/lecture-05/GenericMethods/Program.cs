using System;
using System.Collections.Generic;
using GenericVectors;

namespace GenericMethods
{
   class Program
   {
      // A method generified in the type of element to create the vector
      public static GenericVector<T> CreateAndFill<T>(int size, T elem)
      {
         var v = new GenericVector<T>();
         for (var i=0; i<size; i++) v.AddElement(elem);
         return v;
      }
      // A method generified in the type of elements of the vector to show
      public static void ShowAll<T>(GenericVector<T> vector)
      {
         for (int i=0; i<vector.Size;i++) Console.Write(vector[i]+" ");
         Console.WriteLine();
      }
      static void Main(string[] args)
      {
         // version with explicit indication of type
         GenericVector<string> vs = CreateAndFill<string>(5, "a");
         // version with type inference
         GenericVector<int> vi = CreateAndFill(5, 10); 
         
         // version with explicit indication of type
         ShowAll<int>(vi);
         // version with type inference
         ShowAll(vs); 
      }
   }
}