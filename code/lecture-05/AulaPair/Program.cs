using System;

namespace AulaPair
{
   class Program
   {
      static void Main(string[] args)
      {
         var c1 = new Pair<int,int>(0,0);
         int x = c1.First;
         int y = c1.Second;
         
         var c2 = new Pair<double,double>(0.2,0.9);
         double d1 = c2.First;
         
         var c3 = new Pair<string,string>("a","b");
         string s1 = c3.First;
         
         var c4 = new Pair<string,int>("a",10);
         string c4a = c4.First;
         int c4b = c4.Second;
         
         Console.WriteLine(c4.ChgFirst("b"));
         Console.WriteLine(c4.ChgFirst(1.2));

      }
   }

   class Pair<TA,TB>
   {
      public TA First { get; }
      public TB Second { get; }

      public Pair(TA first, TB second)
      {
         First = first;
         Second = second;
      }

      public Pair<TC, TB> ChgFirst<TC>(TC first)
      {
         return new Pair<TC, TB>(first, Second);
      }
      
      public Pair<TA, TB> ChgSecond(TB second)
      {
         return new Pair<TA, TB>(First, second);
      }
      



      public override string ToString()
      {
         return $"Pair[E1: {First}, E2: {Second}]";
      }
   }
}