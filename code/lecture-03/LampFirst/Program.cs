using System;

namespace LampFirst
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
      private bool _on;
      private double _intensity;

      public Lamp()
      {
         _on = false;
         _intensity = 0.0;
      }

      public void On() => _on = true;
      public void Off() => _on = false;
      public void Dim() => _intensity = (_intensity < 0.1 ? 0 : _intensity - 0.1);
      public void Brighten() => _intensity = (_intensity > 0.9 ? 1.0 : _intensity + 0.1);

      public void SetIntensity(double intensity)
      {
         _intensity = intensity;
         if (_intensity < 0) _intensity = 0;
         if (_intensity > 1.0) _intensity = 1.0;
      }

      public double GetIntensity() => _intensity;
      public bool IsOn() => _on;

      public string AsString() => (_on ? "on" : "off")+", "+_intensity;
   }
}