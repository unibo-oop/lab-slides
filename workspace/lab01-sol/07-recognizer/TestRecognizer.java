class TestRecognizer {
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
       * procedimento analogo a quello appena descritto
       * - 1,2,3,4,1,2,3 - 1,2,3,4,5 - 1,2,3,4,5,2,3 - ...
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
      System.out.println("Now the result of the check is: " + recognizer.check3(3) + "\n");

      // 1,2,3,4,5
      System.out.println("Reset");
      recognizer.reset();
      System.out.println("Now the result of the check is: " + recognizer.check1(1));
      System.out.println("Now the result of the check is: " + recognizer.check2(2));
      System.out.println("Now the result of the check is: " + recognizer.check3(3));
      System.out.println("Now the result of the check is: " + recognizer.check4(4));
      System.out.println("Now the result of the check is: " + recognizer.check1(5) + "\n");

      // 1,2,3,4,5,2,3
      System.out.println("Reset");
      recognizer.reset();
      System.out.println("Now the result of the check is: " + recognizer.check1(1));
      System.out.println("Now the result of the check is: " + recognizer.check2(2));
      System.out.println("Now the result of the check is: " + recognizer.check3(3));
      System.out.println("Now the result of the check is: " + recognizer.check4(4));
      System.out.println("Now the result of the check is: " + recognizer.check1(5));
      System.out.println("Now the result of the check is: " + recognizer.check2(2));
      System.out.println("Now the result of the check is: " + recognizer.check3(3));
  }
}
