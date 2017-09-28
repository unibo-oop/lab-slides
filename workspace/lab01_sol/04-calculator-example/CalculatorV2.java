public class CalculatorV2 {
    int nOpDone;
    double lastRes;

    void build() {
        nOpDone = 0;
        lastRes = 0;
    }

    double add(double n1, double n2) {
        lastRes = n1 + n2;
        nOpDone++;
        return lastRes;
    }

    double sub(double n1, double n2) {
        lastRes = n1 - n2;
        nOpDone++;
        return lastRes;
    }

    double mul(double n1, double n2) {
        lastRes = n1 * n2;
        nOpDone++;
        return lastRes;
    }

    double div(double n1, double n2) {
        lastRes = n1 / n2;
        nOpDone++;
        return lastRes;
    }
}
