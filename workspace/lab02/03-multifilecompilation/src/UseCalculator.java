public class UseCalculator {

    public static void main(final String[] args) {
        final Calculator calc = new Calculator();
        System.out.println("7+21=" + calc.add(1, 2));
        System.out.println("14-1221=" + calc.sub(14, 1221));
        System.out.println("nOpDone=" + calc.nOpDone);
        System.out.println("lastRes=" + calc.lastRes + "\n");
    }

}
