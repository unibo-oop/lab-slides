using System;
using System.Drawing;

namespace Structures
{
    struct Rational
    {
        public Rational(bool sign, uint num, uint den)
        {
            if (den == 0) throw new DivideByZeroException("Denominator cannot be 0");
            Sign = sign; Num = num; Den = den;
        }

        public bool Sign { get; }
        public uint Num { get; }
        public uint Den { get; }

        public bool Equals(Rational other) => 
            Sign == other.Sign && Num == other.Num && Den == other.Den;
        public override bool Equals(object obj) => obj is Rational other && Equals(other);
        public override int GetHashCode() => HashCode.Combine(Sign, Num, Den);

        public override string ToString() => $"{(Sign ? "+" : "-")}{Num}/{Den}";
    }
    
    interface IPoint { double X { get; set; } double Y { get; set; } }
        
    class CPoint : IPoint
    {
        public CPoint(double x, double y) { X = x; Y = y; }
        public double X { get; set; }
        public double Y { get; set; }

        public override string ToString() => $"CPoint(X: {X}, Y: {Y})";
    }
        
    struct SPoint : IPoint
    {
        public SPoint(double x, double y) { X = x; Y = y; }
        public double X { get; set; }
        public double Y { get; set; }
            
        public override string ToString() => $"SPoint(X: {X}, Y: {Y})";
    }
    class Program
    {

        static void Main(string[] args)
        {
            Rational oneHalf = new Rational(true, 1, 2);
            Console.WriteLine(oneHalf); // +1/2
            var minusTwoThird = new Rational(false, 2, 3);
            Console.WriteLine(minusTwoThird); // -2/3
            
            CPoint cPoint1 = new CPoint(1, 2);
            SPoint sPoint1 = new SPoint(3, 4);

            CPoint cPoint2 = cPoint1;
            SPoint sPoint2 = sPoint1;

            cPoint1.X = 5; cPoint1.Y = 6;
            sPoint1.X = 7; sPoint1.Y = 8;

            Console.WriteLine(cPoint1); // CPoint(X: 5, Y: 6)
            Console.WriteLine(sPoint1); // SPoint(X: 7, Y: 8)
            Console.WriteLine(cPoint2); // CPoint(X: 5, Y: 6)
            Console.WriteLine(sPoint2); // SPoint(X: 3, Y: 4)
            
            IPoint cPoint3 = cPoint2;
            IPoint sPoint3 = sPoint2; // BOXING
            
            cPoint2.X = 9; cPoint2.Y = 0;
            sPoint2.X = 1; sPoint2.Y = 2;
            
            Console.WriteLine(cPoint2); // CPoint(X: 9, Y: 0)
            Console.WriteLine(sPoint2); // SPoint(X: 1, Y: 2)
            Console.WriteLine(cPoint3); // CPoint(X: 9, Y: 0)
            Console.WriteLine(sPoint3); // SPoint(X: 3, Y: 4)
            
            CPoint cPoint4 = (CPoint)cPoint3;
            SPoint sPoint4 = (SPoint)sPoint3; // UNBOXING
            
            cPoint3.X = 3; cPoint3.Y = 4;
            sPoint3.X = 5; sPoint3.Y = 6;
            
            Console.WriteLine(cPoint3); // CPoint(X: 3, Y: 4)
            Console.WriteLine(sPoint3); // SPoint(X: 5, Y: 6)
            Console.WriteLine(cPoint4); // CPoint(X: 3, Y: 4)
            Console.WriteLine(sPoint4); // SPoint(X: 3, Y: 4)
        }
    }
}
