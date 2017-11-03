class CallByValueExample {

    void increment(int a) {
        a++;
    }

    public static void main(String[] args) {
        int x = 1;
        CallByValueExample cbv = new CallByValueExample();
        cbv.increment(x);
        System.out.println("x=" + x);
    }
}
