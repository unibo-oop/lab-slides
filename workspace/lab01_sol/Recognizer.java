public class Recognizer {
    int nextNum;
    boolean success;

    void build() {
        nextNum = 1;
        success = true;
    }

    boolean check1(int n) {
        nextNum = 2;
        if (n != 1) {
            success = false;
        }
        return success;
    }

    boolean check2(int n) {
        nextNum = 3;
        if (n != 2) {
            success = false;
        }
        return success;
    }

    boolean check3(int n) {
        nextNum = 4;
        if (n != 3) {
            success = false;
        }
        return success;
    }

    boolean check4(int n) {
        nextNum = 1;
        if (n != 4) {
            success = false;
        }
        return success;
    }

    void reset() {
        nextNum = 1;
        success = true;
    }

    int nextExpectedInt() {
        return nextNum;
    }

    public static void main(String[] args) {
        /*
         * 1) Creare un oggetto della classe Recognizer
         */
        Recognizer recognizer = new Recognizer();
        recognizer.build();

        /*
         * 2) Invocare i metodi check1, check2, ... passando in input il valore
         * corretto (1,2,..)
         * 
         */
        System.out.println("Next expected int is: " + recognizer.nextExpectedInt());
        System.out.println("Now the result of the check is: " + recognizer.check1(1));
        System.out.println("Next expected int is: " + recognizer.nextExpectedInt());
        System.out.println("Now the result of the check is: " + recognizer.check2(2));
        System.out.println("Next expected int is: " + recognizer.nextExpectedInt());
        System.out.println("Now the result of the check is: " + recognizer.check3(3));
        System.out.println("Next expected int is: " + recognizer.nextExpectedInt());
        System.out.println("Now the result of the check is: " + recognizer.check4(4) + "\n");

        /*
         * 3) Testare il riconoscimento per le seguenti sequenze con
         * procedimento analogo a quello appena descritto - 1,2,3,4,1,2,3,4 -
         * 1,2,3,4,5 - 1,2,3,4,1,2,3,4,1,2,7 - ...
         */
        System.out.println("Reset");
        recognizer.reset();

        // 1,2,3,4,1,2,3,4
        System.out.println("Now the result of the check is: " + recognizer.check1(1));
        System.out.println("Now the result of the check is: " + recognizer.check2(2));
        System.out.println("Now the result of the check is: " + recognizer.check3(3));
        System.out.println("Now the result of the check is: " + recognizer.check4(4));
        System.out.println("Now the result of the check is: " + recognizer.check1(1));
        System.out.println("Now the result of the check is: " + recognizer.check2(2));
        System.out.println("Now the result of the check is: " + recognizer.check3(3));
        System.out.println("Now the result of the check is: " + recognizer.check4(4) + "\n");

        // 1,2,3,4,5
        System.out.println("Reset");
        recognizer.reset();
        System.out.println("Now the result of the check is: " + recognizer.check1(1));
        System.out.println("Now the result of the check is: " + recognizer.check2(2));
        System.out.println("Now the result of the check is: " + recognizer.check3(3));
        System.out.println("Now the result of the check is: " + recognizer.check4(4));
        System.out.println("Now the result of the check is: " + recognizer.check1(5) + "\n");

        // 1,2,3,4,1,2,3,4,1,2,7,8,9
        System.out.println("Reset");
        recognizer.reset();
        System.out.println("Now the result of the check is: " + recognizer.check1(1));
        System.out.println("Now the result of the check is: " + recognizer.check2(2));
        System.out.println("Now the result of the check is: " + recognizer.check3(3));
        System.out.println("Now the result of the check is: " + recognizer.check4(4));
        System.out.println("Now the result of the check is: " + recognizer.check4(5));
        System.out.println("Now the result of the check is: " + recognizer.check4(6));
        System.out.println("Now the result of the check is: " + recognizer.check4(7));
        System.out.println("Now the result of the check is: " + recognizer.check4(8));
        System.out.println("Now the result of the check is: " + recognizer.check4(9));
    }
}
