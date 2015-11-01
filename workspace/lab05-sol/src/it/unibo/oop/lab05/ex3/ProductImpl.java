package it.unibo.oop.lab05.ex3;

/**
 * Product implementation.
 * 
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public class ProductImpl implements Product {

    private final String name;
    private final double quantity;

    /**
     * @param n
     *            the product name
     * @param q
     *            the product quantity
     */
    public ProductImpl(final String n, final double q) {
        super();
        this.name = n;
        this.quantity = q;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(final Object obj) {
        if (obj instanceof Product) {
            final Product pr = (Product) obj;
            return name.equals(pr.getName());
        }
        return false;
    }

    public String toString() {
        return "ProductImpl [name=" + name + ", quantity=" + quantity + "]";
    }

}
