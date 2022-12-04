using System;

namespace SmartHome
{
   public class Counter
   {
      public int Value { get; private set; } = 0;

      public virtual void Increment() => Value++;
   }

   public class LimitCounter : Counter
   {
      private int _limit;

      public LimitCounter(int limit) => _limit = limit;

      public int ToLimit => _limit - Value;

      public bool IsOver => ToLimit == 0;

      public override void Increment()
      {
         if (!IsOver) base.Increment();
      }
   }

   public class Device
   {
      public bool IsOn { get; private set; } = false;

      public virtual void SwitchOn() => IsOn = true;

      public void SwitchOff() => IsOn = false;
   }

   public class FiniteDevice : Device
   {
      private readonly LimitCounter _counter;

      public FiniteDevice(int limit) => _counter = new LimitCounter(limit);

      public int RemainingLife => _counter.ToLimit;

      public bool Failed => _counter.IsOver;

      public override void SwitchOn()
      {
         if (IsOn) return;
         _counter.Increment();
         if (!Failed) base.SwitchOn();
      }

      public override string ToString() =>
         Failed ? "failed" : $"{(IsOn ? "on" : "off")}({_counter.Value})";
   }

   public class SmartHomeController
   {
      private const int Limit = 5;
      private readonly FiniteDevice[] _devices;

      public SmartHomeController(int size)
      {
         _devices = new FiniteDevice[size];
         for (var i = 0; i < size; i++) _devices[i] = new FiniteDevice(Limit);
      }

      public FiniteDevice GetDevice(int position) => _devices[position];

      public bool AllWorking()
      {
         foreach (var device in _devices)
            if (device.Failed) return false;
         return true;
      }
      
      public void SwitchOnOne() => Younger()?.SwitchOn();

      private FiniteDevice Younger()
      {
         FiniteDevice younger = null;
         foreach (var device in _devices)
         {
            if (!device.IsOn && 
                device.RemainingLife > (younger?.RemainingLife ?? 0))
            {
               younger = device;
            }
         }

         return younger;
      }

      public override string ToString()
      {
         var s = "";
         foreach (var device in _devices)
         {
            s = s + device.ToString() + "|";
         }
         return s + $" {(AllWorking() ? "ok" : "failures...")}";
      }
   }

   public class UseSmartHomeController
   {
      static void Main(string[] args)
      {
         var controller = new SmartHomeController(3);
         Console.WriteLine(controller); // off(0)|off(0)|off(0)| ok
         controller.GetDevice(0).SwitchOn();
         controller.GetDevice(1).SwitchOn();
         Console.WriteLine(controller); // on(1)|on(1)|off(0)| ok
         controller.SwitchOnOne();
         Console.WriteLine(controller); // on(1)|on(1)|on(1)| ok
         controller.GetDevice(0).SwitchOff();
         controller.GetDevice(0).SwitchOn();
         controller.GetDevice(0).SwitchOff();
         controller.GetDevice(0).SwitchOn();
         controller.GetDevice(0).SwitchOff();
         controller.GetDevice(0).SwitchOn();
         Console.WriteLine(controller); // on(4)|on(1)|on(1)| ok
         controller.GetDevice(0).SwitchOff();
         controller.GetDevice(0).SwitchOn();
         Console.WriteLine(controller); // failed|on(1)|on(1)| failures...
      }
   }
}