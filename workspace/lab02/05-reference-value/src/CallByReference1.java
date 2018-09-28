class CallByReference1 {

    void increment(final Point3D p) {
        p.x++;
        p.y++;
        p.z++;
    }

    public static void main(final String[] args) {
        Point3D p = new Point3D();
        p.build(1, 2, 3);
        CallByReference1 cbv2 = new CallByReference1();
        cbv2.increment(p);
        System.out.println("x=" + p.x + ";y=" + p.y + ";z=" + p.z);
    }
}
