using System;

namespace Parameters
{
    struct SomeValueType
    {
        public SomeValueType(int someProperty) { SomeProperty = someProperty; }
        public int SomeProperty { get; set; }
        public override string ToString() => $"SomeValueType({SomeProperty})";
    }

    class SomeReferenceType
    {
        public SomeReferenceType(int someProperty) { SomeProperty = someProperty; }
        public int SomeProperty { get; set; }
        public override string ToString() => $"SomeReferenceType({SomeProperty})";
    }
    
    class Program
    {
        static void Inc(SomeReferenceType arg) => 
            arg.SomeProperty += 1; // side effect on a reference type
        static void Inc(SomeValueType arg) => 
            arg.SomeProperty += 1; // USELESS side effect on a value type

        static void Replace(SomeReferenceType arg) => 
            arg = new SomeReferenceType(arg.SomeProperty + 1); // re-assigning a local parameter
        static void Replace(SomeValueType arg) => 
            arg = new SomeValueType(arg.SomeProperty + 1); // re-assigning a local parameter

        static void IncRef(ref SomeReferenceType arg) => 
            arg.SomeProperty += 1; // side effect on a reference type
        static void IncRef(ref SomeValueType arg) => 
            arg.SomeProperty += 1; // side effect on a value type (affects outer references too)

        static void ReplaceRef(ref SomeReferenceType arg) => 
            arg = new SomeReferenceType(arg.SomeProperty + 1); // re-assigns outer variables too
        static void ReplaceRef(ref SomeValueType arg) => 
            arg = new SomeValueType(arg.SomeProperty + 1); // re-assigns outer variables too
        
        static void ReferenceVsValueParameterPassing()
        {
            SomeReferenceType value1 = new SomeReferenceType(1);
            SomeValueType value2 = new SomeValueType(2);
            
            Console.WriteLine(value1); // SomeReferenceType(1)
            Console.WriteLine(value2); // SomeValueType(2)

            Inc(value1); // attempts to increase a reference to value1
            Inc(value2); // attempts to increase a clone of value1 (leaving value1 unaffected)
            
            Console.WriteLine(value1); // SomeReferenceType(2)
            Console.WriteLine(value2); // SomeValueType(2)
            
            // notice that the objects referenced by value1 and value2 are always the same
            
            Replace(value1); // has no effect
            Replace(value2); // has no effect
            
            Console.WriteLine(value1); // SomeReferenceType(2)
            Console.WriteLine(value2); // SomeValueType(2)
            
            // notice that the objects referenced by value1 and value2 are still the same
        }
        
        static void RefParameterPassing()
        {
            SomeReferenceType value1 = new SomeReferenceType(1);
            SomeValueType value2 = new SomeValueType(2);
            
            Console.WriteLine(value1); // SomeReferenceType(1)
            Console.WriteLine(value2); // SomeValueType(2)
            
            IncRef(ref value1); // attempts to increase a reference to value1
            IncRef(ref value2); // attempts to increase a reference to value2
            
            Console.WriteLine(value1); // SomeReferenceType(2)
            Console.WriteLine(value2); // SomeValueType(3)
            
            // notice that the objects referenced by value1 and value2 are still the same
            
            ReplaceRef(ref value1); // attempts to replace a reference to value1
            ReplaceRef(ref value2); // attempts to replace a reference to value2
            
            Console.WriteLine(value1); // SomeReferenceType(3)
            Console.WriteLine(value2); // SomeValueType(4)
            
            // notice that the objects referenced by value1 and value2 are DIFFERENT now
        }
        
        static void Main(string[] args)
        {
            ReferenceVsValueParameterPassing();
            Console.WriteLine("---");
            RefParameterPassing();
        }
    }
}