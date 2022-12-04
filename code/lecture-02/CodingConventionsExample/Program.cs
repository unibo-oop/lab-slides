using System;

namespace CodingConventionsExample {
    class Persona
    {

        private String name;
        private string surname;
        private int _anni;

        public string Full_Name
        {
            get { return name+surname; }
        }

        string Surname
        {
            get
            {
                return surname ;
            }
        }

        public override string ToString()
        {
            var content = string.Format("full name: {0}, age: {1}" , Full_Name , age);
            return "Persona("+ content +")";
        }

        public Int32 age => _anni;

        static void Main(string[] Args)
        {
            var _persona = new Persona();
            var full_name = _persona.Full_Name;
			Console.WriteLine(_persona.ToString());
        }
    }
}