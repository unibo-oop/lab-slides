class Point3D {
    double x;
    double y;
    double z;

    void build(final double a, final double b, final double c) {
        this.x = a;
        this.y = b;
        this.z = c;
    }

    double getModulo2() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    boolean equal(final Point3D q) {
        return this.x == q.x && this.y == q.y && this.z == q.z;
    }

    public static void main(final String[] s) {
        Point3D p = new Point3D();
        p.build(10.0, 20.0, 30.0);
        Point3D q = new Point3D();
        q.build(10.0, 20.0, 31.0);
        System.out.println("Modulo quadro di p: " + p.getModulo2());
        System.out.println("p e' uguale a q? : " + p.equal(q));
    }
}
