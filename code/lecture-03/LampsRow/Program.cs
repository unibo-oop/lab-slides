using System;
using Lamps;

namespace LampsRow
{
   public class UseLampsRow
   {
      public static void Main(string[] args)
      {
         var lampsRow = new LampsRow(3);
         lampsRow.InstallLamp(0,new Lamp());
         lampsRow.InstallLamp(1,new Lamp());
         lampsRow.InstallLamp(2,new Lamp());
         lampsRow.RemoveLamp(1);
         lampsRow.SwitchAll(true);
         lampsRow.GetLamp(0).Intensity = 0.5;
         lampsRow.GetLamp(2).Intensity = 0.7;
         for (var i = 0; i < 3; i++)
         {
            Console.WriteLine(i+" "+lampsRow.GetLamp(i)?.AsString());
         }
      }
   }

   public class LampsRow
   {
      // Composition of many lamps
      private readonly Lamp[] _row;
      
      public LampsRow(int size) => _row = new Lamp[size];

      public Lamp GetLamp(int position) => _row[position];
      
      public void InstallLamp(int position, Lamp lamp) => _row[position] = lamp;
      
      public void RemoveLamp(int position) => _row[position] = null;

      public bool IsInstalled(int position) => _row[position] != null;
      
      public void SwitchAll(bool on)
      {
         foreach (var lamp in _row)
         {
            if (on) lamp?.SwitchOn(); else lamp?.SwitchOff();
         }
      }
   }
}