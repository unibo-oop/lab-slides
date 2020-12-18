class ComplexNumCalculator {
    int nOpDone;
    ComplexNum lastRes;

    void build() {
        nOpDone = 0;
    }

    ComplexNum add(ComplexNum n1, ComplexNum n2) {
        ComplexNum returnValue = new ComplexNum();
        returnValue.build(n1.re + n2.re, n1.im + n2.im);
        return doOp(returnValue);
    }

    ComplexNum sub(ComplexNum n1, ComplexNum n2) {
        ComplexNum returnValue = new ComplexNum();
        returnValue.build(n1.re - n2.re, n1.im - n2.im);
        return doOp(returnValue);
    }

    ComplexNum mul(ComplexNum n1, ComplexNum n2) {
        ComplexNum returnValue = new ComplexNum();
        returnValue.build(n1.re * n2.re - n1.im * n2.im, n1.im * n2.re + n1.re * n2.im);
        return doOp(returnValue);
    }

    ComplexNum div(ComplexNum n1, ComplexNum n2) {
        ComplexNum returnValue = new ComplexNum();
        double re = (n1.re * n2.re + n1.im * n2.im) / (n2.re * n2.re + n2.im * n2.im);
        double im = (n1.im * n2.re - n1.re * n2.im) / (n2.re * n2.re + n2.im * n2.im);
        returnValue.build(re, im);
        return doOp(returnValue);
    }

    ComplexNum doOp(ComplexNum result) {
        nOpDone++;
        lastRes = result;
        return lastRes;
    }
}
