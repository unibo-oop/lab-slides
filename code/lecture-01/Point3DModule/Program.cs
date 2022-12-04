using System;

namespace Point3DModule
{
   class Program
   {
      public static void Main(string[] args)
      {
         var p1 = new Point3D(10, 20, 30);
         var p2 = new Point3D(p1.X*2, p1.Y*2, p1.Z*2);
         Console.WriteLine(Point3DHelpers.Max(p1,p2).AsString);
         Console.WriteLine(Point3DHelpers.Sum(p2,Point3DHelpers.Zero).AsString);
      }
   }
   public class Point3D
   {
      public double X { get; }
      public double Y { get; }
      public double Z { get; }
      public Point3D(double x, double y, double z)
      {
         X = x;
         Y = y;
         Z = z;
      }
      public double SquareModulus => X * X + Y * Y + Z * Z;
      public string AsString => $"X: {X}, Y: {Y}, Z: {Z}";
   }
   
   public static class Point3DHelpers
   {
      public static readonly Point3D Zero = new Point3D(0, 0, 0);
      public static Point3D Max(Point3D p1, Point3D p2) =>
         p1.SquareModulus > p2.SquareModulus ? p1 : p2;
      public static Point3D Sum(Point3D p1, Point3D p2) =>
         new Point3D(p1.X + p2.X, p1.Y + p2.Y, p1.Z + p1.Z);
   }
}