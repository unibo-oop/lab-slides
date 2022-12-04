using System;

namespace Point3DCons
{
   public class UsePoint3D
   {
      public static void Main()
      {
         var p = new Point3D(10.0, 20.0, 30.0);    // istantiation with args
         // Point3D q = new Point3D(); // constructor with 0-args no more possible 
         Console.WriteLine(p.GetSquareModulus());
      }
   }
   public class Point3D
   {
      private double _x;
      private double _y;
      private double _z;

      public Point3D(double x, double y, double z)
      {
         _x = x;
         _y = y;
         _z = z;
      }

      public double GetSquareModulus()
      {
         return _x * _x + _y * _y + _z * _z;
      }
   }
}