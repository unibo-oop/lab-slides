using System;

namespace FieldsApp
{
   public class Fields
   {
      public static void Main()
      {
         A obj = new A();
         int a = obj.i;	 // a will hold 0
         int b = obj.j;	 // b will hold 2
         obj.i = 10;	     // modifying obj's state
         int d = obj.i;	 // d will hold 10
         obj.o = new Object();  // reassignment of obj.o
         A obj2 = new A();
         obj.i = obj2.i;	 // what will obj.i hold?
         bool b2 = !obj.b; // what will b2 hold? (! is negation)
      }
   }

   class A
   {
      public int i;
      public int j = 2;
      public Object o;
      public bool b;
   }
}