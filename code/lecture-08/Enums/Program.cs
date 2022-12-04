using System;

namespace Enums
{
    enum SingleDayOfWeek : byte // defaults to int if nothing is specified
    {
        Monday,     // defaults to 0
        Tuesday,    // defaults to 1
        Wednesday,  // defaults to 2
        Thursday,   // defaults to 3
        Friday,     // defaults to 4
        Saturday,   // defaults to 5
        Sunday      // defaults to 6
    }

    [Flags] // notice this attribute!
    enum DaysOfWeek : byte
    {
        None = 0,
        Monday = 1,
        Tuesday = 2,
        Wednesday = 4,
        Thursday = 16,
        Friday = 32,
        Saturday = 64,
        Sunday = 128,
        
        WorkingDays = Monday | Thursday | Wednesday | Thursday | Friday,
        Weekend = Saturday | Sunday,
        
        EvenDays = Tuesday | Thursday | Saturday,
        OddDays = Monday | Wednesday | Friday
    }
    
    class Program
    {
        public static bool IsWeekend(SingleDayOfWeek day) => 
            day > SingleDayOfWeek.Friday;
        
        public static bool IsOdd(SingleDayOfWeek day) => 
            (int)day % 2 == 0 && day != SingleDayOfWeek.Sunday;

        public static bool IsWeekend(DaysOfWeek day) => 
            (day & DaysOfWeek.Weekend) != DaysOfWeek.None;
        
        public static bool IsOdd(DaysOfWeek day) => 
            (day & DaysOfWeek.OddDays) != DaysOfWeek.None;
        
        static void Main(string[] args)
        {
            SingleDayOfWeek first = SingleDayOfWeek.Monday;
            Console.WriteLine(first); // Monday
            Console.WriteLine((byte)first); // 0
            SingleDayOfWeek second = (SingleDayOfWeek)1;
            Console.WriteLine(second == SingleDayOfWeek.Tuesday); // true
            Console.WriteLine(second > SingleDayOfWeek.Sunday); // false
            Console.WriteLine(second + 1); // Wednesday
            Console.WriteLine("---");
            foreach (SingleDayOfWeek day in Enum.GetValues(typeof(SingleDayOfWeek)))
            {
                bool valueIsWeekend = IsWeekend(day);
                string name = Enum.GetName(typeof(SingleDayOfWeek), day);
                Console.WriteLine(name + ", weekend: " + valueIsWeekend);
            }
            Console.WriteLine("---");
            foreach (var name in new string[] { "monday", "tuesday", "wednesday", "thursday", 
                "friday", "saturday", "sunday" })
            {
                DaysOfWeek day = Enum.Parse<DaysOfWeek>(name, /* ignore case: */ true);
                bool valueIsWeekend = IsOdd(day);
                Console.WriteLine(day + ", odd: " + valueIsWeekend);
            }
        }
    }
}