using System;

namespace PolyObject
{
   class Program
   {
      static void Main(string[] args)
      {
         var objects = new object[5];
         objects[0] = "hello!";
         objects[1] = new object();
         objects[2] = 10; // boxing to a System.Int32
         objects[3] = DateTime.Now;
         objects[4] = new int[] {10, 20, 30};

         PrintAll(objects);
      }
      
      private static void PrintAll(object[] objects)
      {
         foreach (var obj in objects)
         {
            // Polymorphic call to ToString
            Console.WriteLine(obj.ToString());
            // Giving a representation of obj's type
            Console.WriteLine(obj.GetType()); 
         }
      }
   }
}