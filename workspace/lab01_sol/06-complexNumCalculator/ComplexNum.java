class ComplexNum {
  double re;
  double im;

  void build(double re, double im) {
      this.re = re;
      this.im = im;
  }

  boolean equal(ComplexNum num) {
      return (re == num.re) && (im == num.im);
  }

  void add(ComplexNum num) {
      re += num.re;
      im += num.im;
  }

  String toStringRep() {
      return re + ((im > 0) ? "+" + im : "" + im) + "i";
  }
}
