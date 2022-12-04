using System;

namespace Point3DFluent
{
   public class UsePoint3D
   {
      public static void Main()
      {
         var p = new Point3D();    // istantiation
         p.Init(10.0,20.0,30.0); // initialisation 
         var q = new Point3D(); 
         q.Init(10.0,20.0,31.0);
         var r = new Point3D().Build(20.0, 30.0, 40.0); 
         Console.WriteLine(r.GetSquareModulus());
      }
   }
   public class Point3D
   {
      private double _x;
      private double _y;
      private double _z;
      public void Init(double x, double y, double z)  
      {
         _x = x; _y = y; _z = z;
      }
      public Point3D Build(double x, double y, double z)  // fluent pattern
      {
         Init(x,y,z);
         return this; // return the object itself
      }
      public double GetSquareModulus()
      {
         return _x * _x + _y * _y + _z * _z;
      }
   }
}