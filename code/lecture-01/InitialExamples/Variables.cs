using System;

namespace Variables
{
   public class Variables
   {
      public static void Code()
      {
         // An object is created by the special operator <new>
         // It takes 0,1 or many arguments, depending on its type:
         // such arguments are of any type
         String str = new String("example");
         Point2D point = new Point2D(10.5, 20.3);
         Object obj = new Object();
         String str2 = "alternative"; // an ad-hoc syntax
         int i = 5;
      }
   }

   class Point2D
   {
      private double x, y;

      public Point2D(double x, double y)
      {
         this.x = x;
         this.y = y;
      }
   }
}