using System;

namespace FirstPoint3D
{
   public class UsePoint3D
   {
      public static void Main()
      {
         var p = new Point3D(); p.Init(10.0,20.0,30.0); 
         var q = new Point3D(); q.Init(10.0,20.0,31.0);
         Console.WriteLine("Square modulus of p is " + p.GetSquareModulus());
         Console.WriteLine("Are p and q equal? " + p.IsEqual(q));
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
      public double GetSquareModulus()
      {
         return _x * _x + _y * _y + _z * _z;
      }
      public bool IsEqual(Point3D q)
      {
         return _x == q._x && _y == q._y && _z == q._z;
      }
   }
}