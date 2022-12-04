using System;

namespace Point3DToString
{
   class Program
   {
      public static void Main(string[] args)
      {
         var p1 = new Point3D(10, 20, 30);
         var p2 = new Point3D(p1.X*2, p1.Y*2, p1.Z*2);
         var p3 = Point3D.Zero;
         Console.WriteLine(Point3D.Max(p1,p2).AsString);
         Console.WriteLine(Point3D.Max(p2,p3).AsString);
      }
   }
   class Point3D
   {
      public static readonly Point3D Zero = new Point3D(0, 0, 0);
      public double X { get; }
      public double Y { get; }
      public double Z { get; }

      public Point3D(double x, double y, double z)
      {
         X = x;
         Y = y;
         Z = z;
      }

      public static Point3D Max(Point3D p1, Point3D p2) =>
         p1.SquareModulus > p2.SquareModulus ? p1 : p2;

      public double SquareModulus => X * X + Y * Y + Z * Z;

      public string String => $"X: {X}, Y: {Y}, Z: {Z}";
   }
}