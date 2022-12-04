using System; 
// https://docs.microsoft.com/en-us/dotnet/api/system?view=net-5.0

namespace PlayWithLibraries
{
   class Program
   {
      public static void Main()
      {
         Console.WriteLine("The result of 8+2 is " + 10);
         Console.WriteLine("The result of 8+2 is " + (8+2));
         Console.WriteLine("The result of {0}+{1} is {2}",8,2,10);
         var res = 8 + 2;
         Console.WriteLine($"The result of 8+2 is {res}");
         Console.WriteLine($"The result of 8+2 is {2+8}");
         
         var date1 = new DateTime(2008, 3, 1, 7, 0, 0);
         Console.WriteLine(date1.ToString()); // 3/1/2008 7:00:00 AM
         var date2 = date1.AddMinutes(30);
         Console.WriteLine(date2.ToString()); // 3/1/2008 7:30:00 AM

         var rand = new Random();
         Console.WriteLine("{0},{1}", rand.Next(10), rand.Next(10));
         Console.WriteLine(rand.NextDouble()); // in [0..1]

         Console.Write("Input a number here: ");
         String str = Console.ReadLine(); // read from console
         int number = Int32.Parse(str);   // convert to int (if possible)
         Console.WriteLine(number);
      }
   }
}