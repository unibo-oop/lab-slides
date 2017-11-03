class CallByReferenceExample1 {

    void increment(Point3D p) {
        p.x++;
        p.y++;
        p.z++;
    }

    public static void main(String[] args) {
        Point3D p = new Point3D();
        p.build(1, 2, 3);
        CallByReferenceExample1 cbv2 = new CallByReferenceExample1();
        cbv2.increment(p);
        System.out.println("x=" + p.x + ";y=" + p.y + ";z=" + p.z);
    }
}
