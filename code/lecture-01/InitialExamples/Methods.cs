using System;

namespace Methods
{
   public class Methods
   {
      public static void Main()
      {
         A obj = new A();
         int v = obj.i; // 0
         obj.Add(10); // modifying obj
         obj.Add(20); // modifying obj
         int v2 = obj.i; // 30
         int v3 = obj.ReturnValue(); // 30
      }
   }

   class A {
      public int i;
      public void Add(int a){ // input "int a"
         i = i + a;              
      }
      public int ReturnValue(){  // header/signature
         return i;               // body
      }
   }
}