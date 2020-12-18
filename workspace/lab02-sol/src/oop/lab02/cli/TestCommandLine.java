package oop.lab02.cli;

public class TestCommandLine {

    private TestCommandLine() {
    }

    public static void main(final String[] args) {
        /*
         * Write the main method in such a way that it iterates through the
         * array of arguments, printing each one along with the length of the
         * string - the String class provides a
         * 
         * int length()
         * 
         * method that returns the length of the String.
         * 
         * Example output:


           java oop.lab02.cli.TestCommandLine it's a trap

           The provided arguments are:
            * it's, 4 characters long
            * a, 1 characters long
            * trap, 4 characters long


         */
        if (args.length == 0) {
            System.out.println("No argument has been provided.");
        } else {
            System.out.println("The provided arguments are:");
            for (final String arg: args) {
                System.out.println(" * " + arg + ", " + arg.length() + " characters long");
            }
        }
    }

}
