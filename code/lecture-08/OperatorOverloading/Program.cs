using System;

namespace OperatorOverloading
{
    public class Complex
    {
        public static readonly Complex I = new Complex(0, 1);
        
        public static Complex Polar(double modulus, double phase) => 
            new Complex(modulus * Math.Cos(phase), modulus * Math.Sin(phase));
        
        public Complex(double real, double imaginary) { Real = real; Imaginary = imaginary; }
        
        
        public double Real { get; } 
        public double Imaginary { get; }
        public double Modulus => Math.Sqrt(Real * Real + Imaginary * Imaginary);
        public double Phase => Math.Atan2(Imaginary, Real);
        
        
        public override string ToString() => $"{Real} + {Imaginary}*i";
        
        public override int GetHashCode() => HashCode.Combine(Real, Imaginary);
        
        public override bool Equals(object obj)
        {
            var other = obj as Complex;
            return !ReferenceEquals(other, null) 
                   && Real.Equals(other.Real) 
                   && Imaginary.Equals(other.Imaginary);
        }

        public static Complex operator -(Complex c) => new Complex(-c.Real, -c.Imaginary);
        public static Complex operator +(Complex c1, Complex c2) => 
            new Complex(c1.Real + c2.Real, c1.Imaginary + c2.Imaginary);
        public static Complex operator -(Complex c1, Complex c2) => c1 + (-c2);
        public static Complex operator *(Complex c1, Complex c2) =>
            Polar(c1.Modulus * c2.Modulus, c1.Phase + c2.Phase);
        public static Complex operator /(Complex c1, Complex c2) =>
            Polar(c1.Modulus / c2.Modulus, c1.Phase - c2.Phase);

        public static bool operator ==(Complex c1, Complex c2) => c1.Equals(c2);
        public static bool operator !=(Complex c1, Complex c2) => !(c1 == c2);

        public static implicit operator Complex(double x) => new Complex(x, 0);
        public static explicit operator double(Complex c) =>
            c.Imaginary == 0.0 ? c.Real : throw new InvalidCastException("Not a real: " + c);
    }

    class Program
    {
        static void Main(string[] args)
        {
            int one = 1;
            Complex c = one + Complex.I; // implicit cast from int to double and then to Complex
            Console.WriteLine(c); // 1 + 1*i
            c *= 2; // implicit cast from int to double and then to Complex, before multiplication 
            Console.WriteLine(c); // 2,0000000000000004 + 2*i
            c = 1 / c; // "inverse" operator is somewhat implicitly defined
            Console.WriteLine(c); // 0,25 + -0,24999999999999994*i
            c += Complex.I * 0.25; // "multiply by scalar" is somewhat implicitly defined
            Console.WriteLine(c); // 0,25 + 5,551115123125783E-17*i
            c = (double) c; // InvalidCastException: Not a real: 0,25 + 5,551115123125783E-17*i
            Console.WriteLine(c); // NOT EXECUTED
        }
    }
}