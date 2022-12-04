using System;
using System.Data;

namespace LampInterface
{
   public class TestProgram
   {
      public static void Main(string[] args)
      {
         var lamp = new Lamp();
         Console.WriteLine(lamp.AsString()); // off, 0.0
         lamp.On();
         lamp.SetIntensity(0.5);
         lamp.Dim();
         lamp.Dim();
         Console.WriteLine(lamp.AsString()); // on, 0.3
         lamp.Brighten();
         Console.WriteLine(lamp.AsString()); // on, 0.4
         lamp.Off();
         Console.WriteLine(lamp.AsString()); // off, 0.4
      }
   }

   public class Lamp
   {
      public Lamp() { }

      public void On() { }
      public void Off() { }

      public void Dim() { }
      public void Brighten() { }
      public void SetIntensity(double intensity) { }

      public double GetIntensity() => 0.0;
      public bool IsOn() => false;

      public string AsString() => "";
   }
}