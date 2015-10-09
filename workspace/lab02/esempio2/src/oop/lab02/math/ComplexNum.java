package oop.lab02.math;

class ComplexNum {

	double re;
	double im;

	void build(final double re, final double im) {
		this.re = re;
		this.im = im;
	}

	boolean equal(final ComplexNum num) {
		return re == num.re && im == num.im;
	}

	void add(final ComplexNum num) {
		re += num.re;
		im += num.im;
	}

	String toStringRep() {
		return re + (im > 0 ? "+" : "") + im + "i";
	}

	public static void main(final String[] args) {

		// 1-4) creazione di c1,c2,c3,c4
		final ComplexNum c1 = new ComplexNum();
		c1.build(3, 5);

		final ComplexNum c2 = new ComplexNum();
		c2.build(7, -4);

		final ComplexNum c3 = new ComplexNum();
		c3.build(-2, 3);

		final ComplexNum c4 = new ComplexNum();
		c4.build(-2, 3);

		/*
		 * 5) Stampare in standard output la rappresentazione testuale di
		 * c1,c2,c3,c4
		 */
		System.out.println(c1.toStringRep());
		System.out.println(c2.toStringRep());
		System.out.println(c3.toStringRep());
		System.out.println(c4.toStringRep() + "\n");

		// 6) Sommare a c1 c2
		c1.add(c2);
		// 7) Sommare a c2 c4
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
	}
}
