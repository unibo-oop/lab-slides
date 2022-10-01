package oop.lab02.math;

public class UseComplex {

    public static void main(final String[] args) {
        final ComplexNum c1 = new ComplexNum();
        c1.build(1, -45);
        final ComplexNum c2 = new ComplexNum();
        c2.build(2, 8);

        System.out.println(c1.toStringRep());
        System.out.println(c2.toStringRep());

        c1.add(c2);
        System.out.println("c1 new value is: " + c1.toStringRep() + "\n");
    }
}
