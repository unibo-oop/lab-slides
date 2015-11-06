package it.unibo.oop.lab05.ex3;

/**
 * Simple test class for {@link Warehouse}.
 * 
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public final class UseWarehouse {

    private UseWarehouse() {
    }

    /**
     * @param args
     *            unused
     */
    public static void main(final String[] args) {

        /*
         * Realize the class "WarehouseImpl" which implements Warehouse, and use
         * it to run the test.
         */

        final Product p1 = new ProductImpl("p1", 100);
        final Product p2 = new ProductImpl("p2", 30);
        final Product p3 = new ProductImpl("p3", 10);

        final Warehouse w = new WarehouseImpl();
        w.addProduct(p3);
        w.addProduct(p1);
        w.addProduct(p2);

        System.out.println(w.allNames());
        System.out.println(w.allProducts());

    }

}
