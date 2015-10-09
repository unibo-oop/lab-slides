package oop.lab02.math;

import oop.lab02.math.ComplexNum;

public class UseComplex {

	public static void main(String[] args) {
		ComplexNum c1 = new ComplexNum();
		c1.build(1, -45);
		ComplexNum c2 = new ComplexNum();
		c2.build(2, 8);

		System.out.println(c1.toStringRep());
		System.out.println(c2.toStringRep());

		c1.add(c2);
		System.out.println("c1 new value is: " + c1.toStringRep() + "\n");

	}
}
