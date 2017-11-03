package it.unibo.oop.lab.reflection01;

/**
 * A dummy clonable class.
 * 
 */
public class ClonableClass {

    private String a;
    private String b;
    private Double d;

    /**
     * 
     * @return a field
     */
    public String getA() {
        return a;
    }

    /**
     * 
     * @param a the value of a field to be set.
     */
    public void setA(final String a) {
        this.a = a;
    }

    /**
     * 
     * @return b field
     */
    public String getB() {
        return b;
    }

    /**
     * 
     * @param b the value of b field to be set.
     */
    public void setB(final String b) {
        this.b = b;
    }

    /**
     * 
     * @return d field
     */
    public Double getD() {
        return d;
    }

    /**
     * 
     * @param d the value of d field to be set.
     */
    public void setD(final Double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "ClonableClass [a=" + a + ", b=" + b + ", d=" + d + "]";
    }
}