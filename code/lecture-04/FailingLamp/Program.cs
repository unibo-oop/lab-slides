using System;

namespace FailingLamp
{
   public class Device
   {
      public bool IsOn { get; private set; } = false;

      public virtual void SwitchOn() => IsOn = true;

      public void SwitchOff() => IsOn = false;
   }

   public abstract class FailingLamp : Device
   {
      public abstract bool Fails { get; }

      protected abstract void SwitchSucceeded();
      
      public override void SwitchOn()
      {
         if (IsOn || Fails) return;
         base.SwitchOn();
         SwitchSucceeded();
      }

      public override string ToString() => 
         $"{GetType().Name}:{(Fails ? "fails" : (IsOn ? "on" : "off"))}";
   }

   public class CountdownLamp : FailingLamp
   {
      private int _countdown;
      public CountdownLamp(int countdown) => _countdown = countdown;
      public override bool Fails => _countdown == 0;
      protected override void SwitchSucceeded() => _countdown--;
   }

   public class InfiniteLamp : FailingLamp
   {
      public override bool Fails => false;
      protected override void SwitchSucceeded() { } 
   }

   public class ExpirationTimeLamp : FailingLamp
   {
      private readonly int _duration;
      private bool _alreadyUsed;
      private DateTime _firstSwitchDate;
      public ExpirationTimeLamp(int durationInSeconds)
      {
         _duration = durationInSeconds;
      }
      public override bool Fails => 
         _alreadyUsed && DateTime.Now.Second - _firstSwitchDate.Second > _duration;
      protected override void SwitchSucceeded()
      {
         if (_alreadyUsed) return;
         _alreadyUsed = true;
         _firstSwitchDate = DateTime.Now;
      }
   }

   class Program
   {
      static void Main(string[] args)
      {
         TestCountdownLamp();
         TestInfiniteLamp();
         TestExpirationTimeLamp();
      }
      private static void TestCountdownLamp()
      {
         FailingLamp fl = new CountdownLamp(3);
         Console.WriteLine(fl); // off
         fl.SwitchOn();
         fl.SwitchOff();
         fl.SwitchOn();
         Console.WriteLine(fl); // on
         fl.SwitchOff();
         fl.SwitchOn();
         Console.WriteLine(fl); // fails
      }
      
      private static void TestInfiniteLamp()
      {
         FailingLamp il = new InfiniteLamp();
         for (var i = 0; i < 100; i++)
         {
            il.SwitchOn();
            il.SwitchOff();
         }
         il.SwitchOn();
         Console.WriteLine(il); // on
      }

      private static void TestExpirationTimeLamp()
      {
         FailingLamp el = new ExpirationTimeLamp(1);
         for (var i = 0; i < 100; i++)
         {
            el.SwitchOn();
            el.SwitchOff();
         }
         el.SwitchOn();
         Console.WriteLine(el); // on
         System.Threading.Thread.Sleep(2000);
         el.SwitchOff();
         el.SwitchOn();
         Console.WriteLine(el); // fails
      }

   }
}