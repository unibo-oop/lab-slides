using System;
using Lamps;

namespace TwoLampsDevice
{
   public class UseTwoLampsDevice
   {
      public static void Main(string[] args)
      {
         var device = new TwoLampsDevice();
         device.First.SwitchOn();
         device.Second.SwitchOn();
         device.First.Intensity = 1.0;
         device.First.Intensity = 0.1;
         Console.WriteLine(device.AsString()); // [on, 0.1: on, 0]
         device.SwitchOffBoth();
         Console.WriteLine(device.AsString()); // [off, 0.1: off, 0]
         device.EcoMode();
         Console.WriteLine(device.AsString()); // [off, 0.1: on, 0.5]
      }
   }

   public class TwoLampsDevice
   {
      // Composition of two lamps: initialised at construction and never modified!
      public Lamp First { get; } = new Lamp();
      public Lamp Second { get; } = new Lamp();

      public void SwitchOnBoth()
      {
         First.SwitchOn();
         Second.SwitchOn();
      }
      public void SwitchOffBoth()
      {
         First.SwitchOff();
         Second.SwitchOff();
      }
      public void EcoMode()
      {
         First.SwitchOff();
         Second.SwitchOn();
         Second.Intensity = 0.5;
      }

      public string AsString() => $"[{First.AsString()}: {Second.AsString()}]";
   }
}