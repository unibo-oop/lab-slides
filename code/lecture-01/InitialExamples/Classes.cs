using System;

namespace Classes
{
   public class Classes
   {
      public static void Code()
      {
         A obj1 = new A();
         A obj2 = new A();
         AnotherExampleOfClass obj3 = new AnotherExampleOfClass();

         A obj4;
         obj4 = new A();
         // obj4 = new AnotherExampleOfClass(); // won't compile
      }
   }

   class A
   {
      // ..members are optionally put here
   }

   class AnotherExampleOfClass
   {
      // ..members are optionally put here
   }
}