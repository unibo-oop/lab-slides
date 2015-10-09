public class CalculatorV1 {

    void build() { }

    double add(double n1, double n2) {
        return n1 + n2;
    }

    double sub(double n1, double n2) {
        return n1 - n2;
    }

    double mul(double n1, double n2) {
        return n1 * n2;
    }

    double div(double n1, double n2) {
        return n1 / n2;
    }

    public static void main(String[] args) {
        CalculatorV1 calc = new CalculatorV1();
        System.out.println("1+2=" + calc.add(1, 2));
        System.out.println("-1-(+2)=" + calc.sub(-1, 2));
        System.out.println("6*3=" + calc.mul(6, 3));
        System.out.println("8/4=" + calc.div(8, 4));
    }
}
