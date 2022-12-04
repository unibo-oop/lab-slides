using System;

namespace MethodsThis
{
   public class MethodsThis
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
         this.i = this.i + a;              
      }
      public int ReturnValue(){  // header/signature
         return this.i;               // body
      }
      public int Get(){  // a method similar to ReturnValue
         return this.ReturnValue(); // use of this in method calls
      }
   }
}