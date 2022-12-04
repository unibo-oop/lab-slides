using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace PreferImmutability
{
   interface IPoint
   {
      int X { get; }
      int Y { get; }
      IPoint ChangeX(int x);
      IPoint ChangeY(int y);
   }
   class Point : IPoint
   {
      public int X { get; }
      public int Y { get; }
      public Point(int x, int y)
      {
         X = x;
         Y = y;
      }
      public IPoint ChangeX(int x) => new Point(x, Y);
      public IPoint ChangeY(int y) => new Point(X, y);
      public override string ToString() => $"({X}:{Y})";
   }
   class Program
   {
      public static void Main()
      {
         var points = new List<IPoint>(new [] {new Point(10, 10), new Point(20, 20)});
         var points2 = points.Select(p => p.ChangeX(0));
         var points3 = points.Select(p => p.ChangeY(0));
         Console.WriteLine(string.Join(";",points.Select(p => p.ToString())));
         Console.WriteLine(string.Join(";",points2.Select(p => p.ToString())));
         Console.WriteLine(string.Join(";",points3.Select(p => p.ToString())));
      }
   }

}