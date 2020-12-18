class TestCalculator {
  public static void main(String[] args) {

      System.out.println("--- Test Calculator V1 ---\n");

      CalculatorV1 calc1 = new CalculatorV1();
      calc1.build();
      
      System.out.println("1+2=" + calc1.add(1, 2));
      System.out.println("-1-(+2)=" + calc1.sub(-1, 2));
      System.out.println("6*3=" + calc1.mul(6, 3));
      System.out.println("8/4=" + calc1.div(8, 4));

      System.out.println("\n--- Test Calculator V2 ---\n");

      CalculatorV2 calc2 = new CalculatorV2();
      calc2.build();

      System.out.println("1+2=" + calc2.add(1, 2));
      System.out.println("nOpDone=" + calc2.nOpDone);
      System.out.println("lastRes=" + calc2.lastRes + "\n");

      System.out.println("-1-(+2)=" + calc2.sub(-1, 2));
      System.out.println("nOpDone=" + calc2.nOpDone);
      System.out.println("lastRes=" + calc2.lastRes + "\n");

      System.out.println("6*3=" + calc2.mul(6, 3));
      System.out.println("nOpDone=" + calc2.nOpDone);
      System.out.println("lastRes=" + calc2.lastRes + "\n");

      System.out.println("8/4=" + calc2.div(8, 4));
      System.out.println("nOpDone=" + calc2.nOpDone);
      System.out.println("lastRes=" + calc2.lastRes + "\n");
  }
}
