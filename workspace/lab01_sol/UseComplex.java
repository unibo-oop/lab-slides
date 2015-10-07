public class UseComplex {

    public static void main(String[] args) {
        ComplexNum c1 = new ComplexNum();
        c1.build(1, -45);
        ComplexNum c2 = new ComplexNum();
        c2.build(2, 8);
        ComplexNum c3 = new ComplexNum();
        c3.build(-6, -4);

        System.out.println(c1.toStringRep());
        System.out.println(c2.toStringRep());
        System.out.println(c3.toStringRep() + "\n");

        c1.add(c2);
        c1.add(c3);
        System.out.println("c1 new value is: " + c1.toStringRep() + "\n");

        ComplexNum c4 = new ComplexNum();
        c4.build(1, 1);
        System.out.println("Is c3 equals to c4? Answer: " + c3.equal(c4));
    }
}
