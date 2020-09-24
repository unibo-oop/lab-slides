class CalculatorV2 {
    int nOpDone;
    double lastRes;

    void build() {
        nOpDone = 0;
        lastRes = 0;
    }

    double add(double n1, double n2) {
        return doOp(n1 + n2);
    }

    double sub(double n1, double n2) {
        return doOp(n1 - n2);
    }

    double mul(double n1, double n2) {
        return doOp(n1 * n2);
    }

    double div(double n1, double n2) {
        return doOp(n1 / n2);
    }

    double doOp(double result) {
        lastRes = result;
        nOpDone++;
        return lastRes;
    }
}
