using System;

namespace Snippets
{
    public class Snippet1Variables
    {
        public static void DefinitionAndAssignment()
        {
            Int32 anInteger;                // initialised to 0, via default value
            Int16 aShorterInteger = -1;     // initialised to -1, via literal
            Int64 aLongerInteger = 1 + 2;   // initialised to 3, via expression
            String aNullString;             // initialised to null, via default value
            String anEmptyString = "";      // initialised to the empty string literal
            String aString = "hello" + " world"; // initialised via an expression
        }
        
        class Person { public String Name { get; set; } } 
        
        public static void Assignment()
        {
            Person aPerson;
            aPerson = new Person();                             // assignment of local var
            aPerson.Name = "Giovanni";                          // assignment of selected var
            aPerson.Name = aPerson.Name + " ciatto".ToUpper();  // assignment via expression
            aPerson.Name += " ciatto".ToUpper();                // same as above but more concise
        }
    }
}