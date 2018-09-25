class TestComplexNum {
    public static void main(String[] args) {

        /*
        * 1-4) creazione di c1,c2,c3,c4
        */
        ComplexNum c1 = new ComplexNum();
        c1.build(3, 5);

        ComplexNum c2 = new ComplexNum();
        c2.build(7, -4);

        ComplexNum c3 = new ComplexNum();
        c3.build(-2, 3);

        ComplexNum c4 = new ComplexNum();
        c4.build(-2, 3);

        /*
        * 5) Stampare in standard output la rappresentazione testuale di
        * c1,c2,c3,c4
        */
        System.out.println(c1.toStringRep());
        System.out.println(c2.toStringRep());
        System.out.println(c3.toStringRep());
        System.out.println(c4.toStringRep() + "\n");

        /*
        * 6) Sommare a c1 c2
        */
        c1.add(c2);
        /*
        * 7) Sommare a c2 c4
        */
        c2.add(c4);

        /*
        * 8) Stampare nuovamente in standard output la rappresentazione
        * testuale di c1,c2,c3,c4
        */
        System.out.println(c1.toStringRep());
        System.out.println(c2.toStringRep());
        System.out.println(c3.toStringRep());
        System.out.println(c4.toStringRep() + "\n");

        /*
        * 10) Invocare il metodo equals su c3 per tre volte, passando come
        * input c1,c2,c4. Stampare il risultato di ciascuna invocazione in
        * standard output
        */
        System.out.println(c3.equal(c1));
        System.out.println(c3.equal(c2));
        System.out.println(c3.equal(c4));
        
        /*
        * Additional test for toStringRep()
        */
        ComplexNum toPrint = new ComplexNum();
        toPrint.build(0, 0);
        System.out.println(toPrint.toStringRep());
        toPrint.build(2, 2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(2, -2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(-2, 2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(-2, -2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(0, -2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(0, 2);
        System.out.println(toPrint.toStringRep());
        toPrint.build(0, -1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(0, 1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(2, 1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(2, -1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(-2, 1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(-2, -1);
        System.out.println(toPrint.toStringRep());
        toPrint.build(2, 0);
        System.out.println(toPrint.toStringRep());
        toPrint.build(-2, 0);
        System.out.println(toPrint.toStringRep());
    }
}
