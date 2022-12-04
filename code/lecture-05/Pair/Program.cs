using System;
using GenericVectors;

namespace Pairs
{
   class UsePairs
   {
      static void Main(string[] args)
      {
         var pair = new Pair<string, int>("ciao", 2);
         Console.WriteLine(pair);
         Console.WriteLine(pair.First.Substring(pair.Second));

         var archive = new GenericVector<Pair<int, string>>();
         archive.AddElement(new Pair<int, string>(1001,"mirko"));
         archive.AddElement(new Pair<int, string>(800,"carla"));
         archive.AddElement(new Pair<int, string>(1003,"mario"));
         Console.WriteLine(archive);
         
         // name of people with id>1000
         var searchResults = new GenericVector<string>();
         for (var i = 0; i < archive.Size; i++)
         {
            if (archive[i].First > 1000) 
               searchResults.AddElement(archive[i].Second);
         }
         Console.WriteLine(searchResults);
         
         // showcasing generic methods
         Console.WriteLine(pair.ChangeFirst(10)); // a Pair<int,int>
         Console.WriteLine(pair.ChangeSecond("10")); // a Pair<string,string>
      }
   }

   public class Pair<TA, TB>
   {
      public TA First { get; }
      public TB Second { get; }
      
      public Pair(TA a, TB b)
      {
         First = a;
         Second = b;
      }

      public Pair<TA, TC> ChangeSecond<TC>(TC c) => new Pair<TA, TC>(First, c);
      
      public Pair<TC, TB> ChangeFirst<TC>(TC c) => new Pair<TC, TB>(c, Second);

      public override string ToString() => $"({First}:{Second})";
   }
}