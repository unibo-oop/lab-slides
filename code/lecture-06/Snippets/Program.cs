using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;

namespace Snippets
{
    class Program
    {
        static void Main(string[] args)
        {
            int Divide(int x, int y) => x / y;
            // ...
            Divide(5, 0); // System.DivideByZeroException: Attempted to divide by zero.

            int Recursive(int x) => x == 0 ? 0 : Recursive(x + 1);
            // ...
            int n = Recursive(1); // Stack overflow.

            int Length(string s) => s.Length;
            // ...
            Length(null); // System.NullReferenceException: Object reference not set to an instance of an object.

            int.Parse("1.5"); // System.FormatException: Input string was not in a correct format.

            var xs = new int[] {1, 2, 3};
            // ...
            xs[4] = 4; // System.IndexOutOfRangeException: Index was outside the bounds of the array

            A x = new B(); 
            A y = (C) x; // System.InvalidCastException: Unable to cast object of type B to type C
        }
        
        class A {}
        class B : A {}
        class C : A {}
    }
}