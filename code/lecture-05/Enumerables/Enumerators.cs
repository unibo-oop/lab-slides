using System;
using System.Collections;
using System.Collections.Generic;

namespace Enumerables
{
   
   /*
   // namespace System.Collections.Generic
   public interface IEnumerator<T> : IDisposable, System.Collections.IEnumerator
   {
      T Current { get; } // gets current element
      
      bool MoveNext();  // move cursor to next position, returns if not "over"

      void Reset();     // could be called to get back at the beginning
      
      void Dispose();   // could be called at the end to release resources
   }
   */
   
   public class UseEnumerator
   {
      public static void TestEnumerator()
      {
         IEnumerator<int> enumerator = new RangeEnumerator(0, 5);
         while (enumerator.MoveNext())
         {
            Console.Write(enumerator.Current+" ");
         }
         enumerator.Dispose(); // optional
      }
   }

   public class RangeEnumerator : IEnumerator<int>
   {
      private readonly int _stop;
      public int Current { get; private set; } 
      
      public RangeEnumerator(int start, int stop)
      {
         Current = start-1;
         _stop = stop;
      }

      public bool MoveNext()
      {
         Current++;
         return Current < _stop;
      }
      
      // other non-important methods
      
      public void Reset() // not interested in implementing it
      {
         throw new NotImplementedException();
      }

      public void Dispose() // nothing to do to dispose
      {
      }
      
      object? IEnumerator.Current => Current; // needed by IEnumerator superinterface
   }
}