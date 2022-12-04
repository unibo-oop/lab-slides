using System;

namespace Point3DMethods
{
   public class Point3DLib
   {
      public static void Code()
      {
         Point3D p=new Point3D(); 
         p.Build(10.0,20.0,30.0);
         Point3D q=new Point3D(); 
         q.Build(10.0,20.0,31.0);
         var m2 = p.GetSquareModulus();
         var b = p.IsEqual(q);      
      }
   }

   class Point3D
   {
      private double x;
      private double y;
      private double z;
      public void Build(double x, double y, double z)
      {
         this.x = x;
         this.y = y;
         this.z = z;
      }
      public double GetSquareModulus()
      {
         return this.x * this.x + this.y * this.y + this.z * this.z;
      }
      public bool IsEqual(Point3D q)
      {
         return this.x == q.x && this.y == q.y && this.z == q.z;
      }
   }
}