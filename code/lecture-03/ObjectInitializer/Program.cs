using System;

namespace ObjectInitializer
{
   public class Student
   {
      public int StudentID { get; set; }
      public string StudentName { get; set; }
      public int Age { get; set; }
      public string Address { get; set; }
   }

   class UseStudent
   {
      static void Main(string[] args)
      {
         // need to have get-set properties
         var std = new Student() {  // object initializer
            StudentID = 1, 
            StudentName = "Bill", 
            Age = 20, 
            Address = "New York"   
         };
         
         // Essentially equivalent to...
         var std2 = new Student(); // default construct is needed
         std2.StudentID = 1;
         std2.StudentName = "Bill";
         std2.Age = 20;
         std2.Address = "New York";
      }
   }
}