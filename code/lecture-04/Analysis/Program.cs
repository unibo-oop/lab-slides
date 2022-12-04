using System;

namespace Analysis
{
   public class E
   {
      public int Val { get; set;}

      public void Update()
      {
         Val++;
         AddDelta();
      }

      public virtual void AddDelta() => Val += 10;
   }

   public class F : E
   {
      public override void AddDelta() =>  Val += 100;
   }

   class Program
   {
      static void Main(string[] args)
      {
         var f = new F();
         f.Val = 10;
         f.Update();
         Console.WriteLine(f.Val); // how much is it?
      }
   }
}