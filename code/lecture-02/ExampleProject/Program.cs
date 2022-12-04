using System;                                     // import symbols from namespace

namespace ExampleProject                                  // namespace definition
{                                                         // begin of namespace scope
  class Program                                           // class definition
  {                                                       // begin of class scope
    static void Main(string[] args)                       // program entry point
    {                                                     // begin of code block
      String toPrint;                                     // var def statement
      String name = args.Length > 0 ? args[0] : "nobody"; // var def+assign statement
      toPrint = "Hello " + name + "!";                    // assignment statement
      Console.WriteLine(toPrint);                         // method call statement
      if (args.Length > 1)                                // if construct
        for (int i = 1; i < args.Length; i++)             // for construct
          Console.WriteLine("Hello " + args[i] + "!");    // method call statement 
    }                                                     // end of code block
  }                                                       // end of class scope
}                                                         // end of namespace scope