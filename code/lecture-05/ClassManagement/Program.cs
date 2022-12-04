using System;
using System.Collections;
using System.Collections.Generic;

namespace ClassManagement
{
   class Program
   {
      static void Main(string[] args)
      {
         var classManagement = new ClassManagement();
         classManagement.AddStudent(new Student{ Id = 100, Name = "Maria"});
         classManagement.AddStudent(new Student{ Id = 101, Name = "Gino", Evaluation = 30});
         classManagement.AddStudent(new Student{ Id = 102, Name = "Marco", Evaluation = 18});

         foreach (var student in classManagement.GetAll()) Console.WriteLine(student);
         Console.WriteLine("---");
         foreach (var name in classManagement.GetNames()) Console.WriteLine(name);
         Console.WriteLine("---");
         foreach (var student in classManagement.GetStudentsWithEvaluation()) 
            Console.WriteLine(student);
      }
   }

   public class Student
   {
      public int Id { get; set; }
      public string Name { get; set; }
      public int? Evaluation { get; set; }

      public override string ToString()
      {
         return $"Id: {Id}, Name: {Name}, Evaluation: {Evaluation}";
      }
   }

   interface IClassManagement
   {
      void AddStudent(Student student);

      IEnumerable<Student> GetAll();
      IEnumerable<string> GetNames();
      IEnumerable<Student> GetStudentsWithEvaluation();
   }

   public class ClassManagement : IClassManagement
   {
      private IList<Student> _students = new List<Student>();

      public void AddStudent(Student student) => _students.Add(student);
      
      public IEnumerable<Student> GetAll()
      {
         foreach (var student in _students) yield return student;
      }

      public IEnumerable<string> GetNames()
      {
         foreach (var student in _students) yield return student.Name;
      }

      public IEnumerable<Student> GetStudentsWithEvaluation()
      {
         foreach (var student in _students)
         {
            if (student.Evaluation != null) yield return student;
         } 
      }
   }
}