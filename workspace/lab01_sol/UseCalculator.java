public class UseCalculator {

    public static void main(String[] args) {
        CalculatorV2 calc = new CalculatorV2();
        System.out.println("7+21=" + calc.add(1, 2));
        System.out.println("14-1221=" + calc.sub(14, 1221));
        System.out.println("nOpDone=" + calc.nOpDone);
        System.out.println("lastRes=" + calc.lastRes + "\n");
        System.out.println("Trying division by zero, an exception will be raised...");
        System.out.println("4/0=" + 4 / 0);
    }

}
