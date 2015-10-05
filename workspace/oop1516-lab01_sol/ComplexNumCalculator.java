public class ComplexNumCalculator {

  int nOpDone;
  ComplexNum lastRes;

  void build(){
    nOpDone = 0;
  }
  
  ComplexNum add(ComplexNum n1, ComplexNum n2){
    ComplexNum returnValue = new ComplexNum();
    returnValue.build(n1.re+n2.re, n1.im+n2.im);
    nOpDone++;
    return lastRes = returnValue;
  }
  
  ComplexNum sub(ComplexNum n1, ComplexNum n2){
    ComplexNum returnValue = new ComplexNum();
    returnValue.build(n1.re-n2.re, n1.im-n2.im);
    nOpDone++;
    return lastRes = returnValue;
  }

  ComplexNum mul(ComplexNum n1, ComplexNum n2){
    ComplexNum returnValue = new ComplexNum();
    returnValue.build(n1.re*n2.re - n1.im*n2.im, n1.im*n2.re + n1.re*n2.im);
    nOpDone++;
    return lastRes = returnValue;
  }
  
  public static void main(String[] args){
    ComplexNumCalculator calculator = new ComplexNumCalculator();
    calculator.build();
    ComplexNum n1 = new ComplexNum();
    ComplexNum n2 = new ComplexNum();
    ComplexNum result;
    
    //add(1+2i, 2+3i) = 3+5i
    n1.build(1, 2);
    n2.build(2, 3);
    result = calculator.add(n1, n2);
    System.out.println("Result of add(1+2i, 2+3i) = " + result.toStringRep() + "\n");
    System.out.println("No. operations done = " + calculator.nOpDone + "\n");
    System.out.println("Last res = " + calculator.lastRes.toStringRep() + "\n");
    //sub(4+5i, 6+7i) = -2-2i
    n1.build(4, 5);
    n2.build(6, 7);
    result = calculator.sub(n1, n2);
    System.out.println("Result of sub(4+5i, 6+7i) = " + result.toStringRep() + "\n");
    System.out.println("No. operations done = " + calculator.nOpDone + "\n");
    System.out.println("Last res = " + calculator.lastRes.toStringRep() + "\n");
    //mul(8+2i, 3-i) = 26-2i
    n1.build(8, 2);
    n2.build(3, -1);
    result = calculator.mul(n1, n2);
    System.out.println("Result of mul(8+2i, 3-i) = " + result.toStringRep() + "\n");
    System.out.println("No. operations done = " + calculator.nOpDone + "\n");
    System.out.println("Last res = " + calculator.lastRes.toStringRep() + "\n");
  }
}
