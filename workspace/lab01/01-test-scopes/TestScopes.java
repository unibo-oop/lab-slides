class TestScopes {
    int a;
    int b;

    void build(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.print("[build method:] I can access the field a (" + this.a + "),");
        System.out.print(" the field b (" + this.b + "),");
        System.out.print(" the input parameter a (" + a + ")");
        System.out.println(" and the input parameter b (" + b + ").");
    }

    void dummyMethod(int c) {
        System.out.print("[dummyMethod:] I can access the field a (" + this.a + "),");
        System.out.print(" the field b (" + this.b + ")");
        System.out.println(" and the input parameter c (" + c + ").");
    }

    void dummyMethod2(int a) {
        int b = 0;
        System.out.print("[dummyMethod2:] I can access the field a (" + this.a + "),");
        System.out.print(" the field b (" + this.b + "),");
        System.out.print(" the input parameter a (" + a + "),");
        System.out.print(" and the local variable b (" + b + ").");
        System.out.println("I have no access to c, dummyMethod's input parameter.");
    }
}
