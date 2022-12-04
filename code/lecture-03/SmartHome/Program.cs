using System;

namespace SmartHome
{
   public interface IDevice
   {
      void SwitchOn();

      void SwitchOff();

      bool IsOn { get; }
   }
   
   public class Lamp : IDevice
   {
      public void SwitchOn() => IsOn = true;

      public void SwitchOff() => IsOn = false;

      public bool IsOn { get; private set; }
      
      // additional methods can be added if needed
   }
   
   // a lamp with erratic switches
   public class ErraticLamp : IDevice
   {
      private bool _on = false; // here, want to use a field
      private readonly Random _random = new Random();
      
      public void SwitchOn() => _on = _random.NextDouble() < 0.95;

      public void SwitchOff() => _on = _random.NextDouble() < 0.05;

      public bool IsOn { get => _on; }
      
      // additional methods can be added if needed
   }
   
   public class TV : IDevice
   {
      public void SwitchOn() => IsOn = true;

      public void SwitchOff() => IsOn = false;

      public bool IsOn { get; private set; }
   }
   
   public class Radio : IDevice
   {
      public void SwitchOn() => IsOn = true;

      public void SwitchOff() => IsOn = false;

      public bool IsOn { get; private set; }
   }

   public class WorkWithDevices
   {
      // A reusabile method, thanks to interfaces
      public static void SwitchOnOffTwice(IDevice d)
      {
         d.SwitchOn();
         d.SwitchOff();
         d.SwitchOn();
         d.SwitchOff();
      }

      public static void Test()
      {
         SwitchOnOffTwice(new Lamp());
         SwitchOnOffTwice(new Radio());
         SwitchOnOffTwice(new TV());
         Lamp lamp = new Lamp();
         SwitchOnOffTwice(lamp);
         IDevice device = new Lamp(); // Lamp is a subtype for IDevice
         SwitchOnOffTwice(device);
         // Lamp lamp = new IDevice(); // No! Cannot instantiate!
         // lamp lamp = device; // No! IDevice is NOT a subtype for Lamp
      }
   }

   public class SmartHome
   {
      private readonly IDevice[] _devices;

      public SmartHome(int size) => _devices = new IDevice[size];

      public void InstallDevice(int position, IDevice device) => _devices[position] = device;
      
      public void RemoveDevice(int position) => _devices[position] = null;
      
      public IDevice GetDevice(int position) => _devices[position];
      
      public void SwitchAll(bool on)
      {
         foreach (var device in _devices)
         {
            if (on) device?.SwitchOn(); else device?.SwitchOff();
         }
      }
      
      public bool IsCompletelyOn {
         get
         { 
            foreach (var device in _devices){
              if (device != null && device.IsOn) return true;
            }
            return false;
         }
      }
   }

   class Program
   {
      public static void Main(string[] args)
      {
         var smartHome = new SmartHome(4);
         smartHome.InstallDevice(0,new TV());
         smartHome.InstallDevice(1,new Lamp());
         smartHome.InstallDevice(2,new Lamp());
         smartHome.InstallDevice(3,new Radio());
         smartHome.SwitchAll(true);
         Console.WriteLine(smartHome.IsCompletelyOn);
         
      }
   }

   public interface ILuminous
   {
      void Dim();
      void Brighten();
   }
   public class NewLamp : IDevice, ILuminous
   {
      public bool IsOn { get; private set; }
      private int _intensity;
      public void SwitchOn() => IsOn = true;
      public void SwitchOff() => IsOn = false;
      public void Dim() => _intensity--;
      public void Brighten() => _intensity++;
   }
   public interface ILuminousDevice : IDevice, ILuminous {}

   // public class NewLamp2 : ILuminousDevice {...}
}