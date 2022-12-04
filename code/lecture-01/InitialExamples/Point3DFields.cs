using System;

namespace Point3DFields
{
   public class Point3DLib
   {
      public static void Code()
      {
         Point3D a = new Point3D(); // Creating due points
         Point3D b = new Point3D();
         a.x = 10.0; // Setting the fields of a
         a.y = 20.0;
         a.z = 30.0;
         b.x = a.x * 2; // Setting the fields of b
         b.y = a.y * 2; // .. starting from those of a
         b.z = a.z * 2;
         double mod2a = a.x * a.x + a.y * a.y + a.z * a.z;
         double mod2b = b.x * b.x + b.y * b.y + b.z * b.z;
         bool aIsGreaterThanB = (mod2a > mod2b); // false      
      }
   }

   class Point3D
   {
      public double x;
      public double y;
      public double z;
   }
}