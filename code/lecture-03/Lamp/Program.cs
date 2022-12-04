using System;

namespace Lamps
{
   public class TestProgram
   {
      public static void Main(string[] args)
      {
         var lamp = new Lamp();
         Console.WriteLine(lamp.AsString()); // off, 0.0
         lamp.SwitchOn();
         lamp.Intensity = 0.52;
         lamp.Dim();
         lamp.Dim();
         Console.WriteLine(lamp.AsString()); // on, 0.3
         lamp.Brighten();
         Console.WriteLine(lamp.AsString()); // on, 0.4
         lamp.SwitchOff();
         Console.WriteLine(lamp.AsString()); // off, 0.4
      }
   }

   public class Lamp
   {
      private const double Delta = 0.1;
      private const int Levels = 10;
      private int _intensityLevel;

      public bool On { get; private set; }

      public double Intensity
      {
         get => _intensityLevel * Delta;
         set => _intensityLevel = CorrectIntensity((int) Math.Round(value / Delta));
      }

      private static int CorrectIntensity(int level) => 
         level < 0 ? 0: level > Levels ? Levels : level;
      
      public void SwitchOn() => On = true;
      
      public void SwitchOff() => On = false;
      
      public void Dim() => _intensityLevel = CorrectIntensity(_intensityLevel-1);
      
      public void Brighten() => _intensityLevel = CorrectIntensity(_intensityLevel+1);
      
      public string AsString() => $"{(On?"on":"off")}, {Intensity}";
   }
}