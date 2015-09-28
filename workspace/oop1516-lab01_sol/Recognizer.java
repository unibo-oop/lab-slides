public class Recognizer {

  int nextNum;
  
  void build(){
    nextNum = 1;
  }
  
  boolean check1(int n){
    nextNum = 2;
    return n==1;
  }
  
  boolean check2(int n){
    nextNum = 3;
    return n==2;
  }
  
  boolean check3(int n){
    nextNum = 4;
    return n==3;
  }
  
  boolean check4(int n){
    nextNum = 1;
    return n==4;
  }

  void reset(){
    nextNum=1;
  }
  
  public static void main(String args[]){

    // 1) Creare un oggetto della classe Recognizer
    Recognizer recognizer = new Recognizer();

    // 2) Invocare i metodi check1, check2, ... passando in input il valore corretto (1,2,..)
    System.out.println("Now the result of the check is: " + recognizer.check1(1));
    System.out.println("Now the result of the check is: " + recognizer.check2(2));
    System.out.println("Now the result of the check is: " + recognizer.check3(3));
    System.out.println("Now the result of the check is: " + recognizer.check4(4)+ "\n");

    /*
     * 3) Testare il riconoscimento per le seguenti sequenze con procedimento analogo a quello appena descritto 
     *    - 1,2,3,4,1,2,3,4 
     *    - 1,2,3,4,5 
     *    - 1,2,3,4,1,2,3,4,1,2,7
     *    - ...
     */
    System.out.println("Reset");
    recognizer.reset();
    //1,2,3,4,1,2,3,4
    System.out.println("Now the result of the check is: " + recognizer.check1(1));
    System.out.println("Now the result of the check is: " + recognizer.check2(2));
    System.out.println("Now the result of the check is: " + recognizer.check3(3));
    System.out.println("Now the result of the check is: " + recognizer.check4(4));
    System.out.println("Now the result of the check is: " + recognizer.check1(1));
    System.out.println("Now the result of the check is: " + recognizer.check2(2));
    System.out.println("Now the result of the check is: " + recognizer.check3(3));
    System.out.println("Now the result of the check is: " + recognizer.check4(4) + "\n");
    //1,2,3,4,5
    System.out.println("Reset");
    recognizer.reset();
    System.out.println("Now the result of the check is: " + recognizer.check1(1));
    System.out.println("Now the result of the check is: " + recognizer.check2(2));
    System.out.println("Now the result of the check is: " + recognizer.check3(3));
    System.out.println("Now the result of the check is: " + recognizer.check4(4));
    System.out.println("Now the result of the check is: " + recognizer.check1(5) + "\n");
    //1,2,3,4,1,2,3,4,1,2,7,8,9
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
