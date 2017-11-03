package oop.lab03;

public class TestEclipseAdvancedAspects {

    private int a;

    TestEclipseAdvancedAspects(final int a) {
        this.a = a;
    }

    public void dummyMethod(final int a) {
        for (int i = 0; i < a; i++) {
            System.out.println("Current iteratioin is + " + i);
        }
    }

    public void anotherDummyMethod(final String s) {
        System.out.println("I'm just delegating the printing of the input string");
        this.print(s);
    }

    private void print(final String s) {
        System.out.println(s);
    }

    public static void main(final String[] args) {
        TestEclipseAdvancedAspects tb = new TestEclipseAdvancedAspects(10);
        tb.dummyMethod(10);
        tb.anotherDummyMethod("Dummy string.");
    }
}