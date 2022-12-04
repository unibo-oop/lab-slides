using System;
using System.Runtime.Serialization;

namespace ThingsToBeAvoided
{
    class Program
    {
        class SomeException : Exception {}
        static void Main(string[] args)
        {
            try
            {
                // code potentially throwing SomeException
            }
            catch (SomeException e)
            {
                // doing nothing here means IGNORING exception of type SomeException
                // in almost ALL cases this is NOT something you want
            }
            
            try
            {
                // code potentially throwing SomeException
            }
            catch (Exception e) // this may catch more than SomeException!
            {
                // handling Exception here
            }
            
            try
            {
                // code potentially throwing SomeException
            }
            catch (SomeException e)
            {
                Console.WriteLine(e.Message);
                // logging alone is rarely sufficient:
                // the program goes on even in case of SomeException
            }
            
            try
            {
                // code potentially throwing SomeException
            }
            catch (SomeException e)
            {
                Console.WriteLine(e.Message);
                throw e; // recall to re-throw the logged exception after logging
                // so that the program is interrupted
            }
        }
    }
}