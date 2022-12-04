using System;

namespace Events
{

    interface IButton
    {
        string Purpose { get; }
        
        void Press();

        // event name: OnPressed
        // type of listeners: any method accepting a string and returning void
        event Action<string> OnPressed;
    }

    class Button : IButton
    {
        public Button(string purpose)
        {
            Purpose = purpose;
        }
        
        public string Purpose { get; }
        
        public void Press()
        {
            if (OnPressed != null) OnPressed(Purpose); // propagates to ALL listeners
            // or simply: OnPressed?.Invoke(Purpose);
        }

        public event Action<string> OnPressed;
    }
    
    class Program
    {
        static void OnButtonPressed(string purpose) => 
            Console.WriteLine($"{purpose} has been pressed, caught by method");
        
        static void Main(string[] args)
        {
            Action<string> listener = purpose => {
                Console.WriteLine($"{purpose} has been pressed, caught by lambda");
            };
            IButton esc = new Button("Esc");
            esc.OnPressed += listener; // adding a listener: reference to lambda
            IButton enter = new Button("Enter");
            enter.OnPressed += OnButtonPressed; // adding a listener: reference to method 
            
            esc.Press(); // Esc has been pressed, caught by lambda
            enter.Press(); // Enter has been pressed, caught by method
        }
    }
}