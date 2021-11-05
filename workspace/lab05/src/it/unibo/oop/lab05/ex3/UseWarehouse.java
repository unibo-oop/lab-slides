package it.unibo.oop.lab05.ex3;

import static it.unibo.oop.lab05.Assertions.assertContentEqualsInAnyOrder;

import java.util.Set;

/**
 * Simple test class for {@link Warehouse}.
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
         * Realize the classes:
         *
         * 1) WarehouseImpl implements Warehouse. Such class should use internally
         * a java.util.LinkedHashSet. Differently from HashSet the iteration order
         * of LinkedHashSet is predictable and reproducible even when using object
         * that don't implement a custom hashCode.
         * Additionally, LinkedHashSet and HashSet have similar performances:
         * https://www.artima.com/weblogs/viewpost.jsp?thread=122295
         *
         * 2) ProductImpl implements Product. Remember that two products are the
         * same if their name is the same.
         *
         * Read VERY carefully the comments in the implemented interfaces and use
         * them to run the test.
         */

        final Product p1 = null;
        final Product p2 = null;
        final Product p3 = null;

        final Warehouse w = null;
        w.addProduct(p3);
        assertContentEqualsInAnyOrder(Set.of(p3), w.allProducts());
        w.addProduct(p1);
        assertContentEqualsInAnyOrder(Set.of(p1, p3), w.allProducts());
        w.addProduct(p2);
        assertContentEqualsInAnyOrder(Set.of(p1, p2, p3), w.allProducts());

        System.out.println(w.allProducts());
        System.out.println(w.allNames());
        assertContentEqualsInAnyOrder(Set.of(p1.getName(), p2.getName(), p3.getName()), w.allNames());

        // Changes to the returned set should not affect the warehouse
        final var modifiedProductSet = w.allProducts();
        modifiedProductSet.remove(p1);

        System.out.println(w.allNames());
        assertContentEqualsInAnyOrder(Set.of(p1.getName(), p2.getName(), p3.getName()), w.allNames());
        System.out.println(w.allProducts());
        assertContentEqualsInAnyOrder(Set.of(p1, p2, p3), w.allProducts());
        System.out.println(modifiedProductSet);
        assertContentEqualsInAnyOrder(Set.of(p2, p3), modifiedProductSet);
    }

}
