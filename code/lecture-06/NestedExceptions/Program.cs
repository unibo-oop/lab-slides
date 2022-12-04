using System;
using System.Runtime.Serialization;

namespace NestedExceptions
{
    class SomeException : Exception
    {
        public SomeException() { }
        
        public SomeException(string? message) : base(message) { }
        
        public SomeException(string? message, Exception? innerException) : base(message, innerException) { }
    }
    class SomeOtherException : Exception
    {
        public SomeOtherException() { }
        
        public SomeOtherException(string? message) : base(message) { }
        
        public SomeOtherException(string? message, Exception? innerException) : base(message, innerException) { }
    }
    
    class Program
    {
        static void MethodPossiblyThrowingSomeException()
        {
            if (new Random().NextDouble() < 0.5)
                throw new SomeException("A message");
            else
                MethodPossiblyThrowingSomeException();
        }
        
        static void Main(string[] args)
        {
            try
            {
                MethodPossiblyThrowingSomeException();
            }
            catch (SomeException e)
            {
                throw new SomeOtherException("Another message", e);
            }
        }
    }
}