using System;

namespace Queues
{
    interface IFixedSizeQueue
    {
        uint Capacity { get; } // max amount of items in the queue
        
        object GetFirst(); // retrieves & removes the first item in the queue, if any

        void AddLast(object item); // appends item at the end of the queue, if possible
    }

    public abstract class QueueException : InvalidOperationException
    {
        protected QueueException() { }
        protected QueueException(string? message) : base(message) { }
        protected QueueException(string? message, Exception? innerException) 
            : base(message, innerException) { }
    }
    public class EmptyQueueException : QueueException
    {
        public EmptyQueueException() { }
        public EmptyQueueException(string? message) : base(message) { }
        public EmptyQueueException(string? message, Exception? innerException) 
            : base(message, innerException) { }
    } 
    public class FullQueueException : QueueException
    {
        public FullQueueException() { }
        public FullQueueException(string? message) : base(message) { }
        public FullQueueException(string? message, Exception? innerException) 
            : base(message, innerException) { }
    } 
    class Program
    {

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}