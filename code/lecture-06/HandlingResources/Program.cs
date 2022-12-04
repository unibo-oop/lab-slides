using System;
using System.IO;
using System.Threading;

namespace HandlingResources
{
    class Printer
    {
        private Random _rand = new Random();
        
        public bool IsBusy { get; private set; }
        
        public void Reserve()
        {
            if (IsBusy) throw new InvalidOperationException("The printer is currently busy");
            IsBusy = true;
        }
        
        public void Print()
        {
            Thread.Sleep(1000); // wait 1 second
            if (_rand.NextDouble() < 0.5) Console.WriteLine("Correctly printed!");
            else throw new IOException("Communication with printer failed");
        }
        
        public void Release()
        {
            if (!IsBusy) throw new InvalidOperationException("The printer is not busy");
            IsBusy = false;
        }
    }
    
    class Program
    {
        static void Wrong()
        {
            var printer = new Printer();
            while (true)
            {
                try
                {
                    printer.Reserve();
                    printer.Print();
                    printer.Release();
                }
                catch (IOException e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        static void Correct()
        {
            var printer = new Printer();
            while (true)
            {
                try
                {
                    printer.Reserve();
                    printer.Print();
                }
                catch (IOException e)
                {
                    Console.WriteLine(e.Message);
                }
                finally
                {
                    printer.Release();
                }
            }
        }
        
        static void Main(string[] args)
        {
            Wrong();
        }
    }
}