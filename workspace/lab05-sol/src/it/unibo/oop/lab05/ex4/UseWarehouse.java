package it.unibo.oop.lab05.ex4;

import static it.unibo.oop.lab05.Assertions.assertContentEqualsInAnyOrder;
import static it.unibo.oop.lab05.Assertions.assertContentEqualsInOrder;

import java.util.List;
import java.util.Set;

import it.unibo.oop.lab05.ex3.Product;
import it.unibo.oop.lab05.ex3.Warehouse;

/**
 *
 */
public final class UseWarehouse {

    private UseWarehouse() { }

    /**
     * @param args
     *            unused
     */
    public static void main(final String[] args) {
        final Product p1 = new ComparableProduct("Apple", 100);
        final Product p2 = new ComparableProduct("Banana", 30);
        final Product p3 = new ComparableProduct("Watermelon", 10);

        final Warehouse w = new OrderedWarehouse();
        w.addProduct(p3);
        assertContentEqualsInOrder(List.of(p3), w.allProducts());
        w.addProduct(p1);
        assertContentEqualsInOrder(List.of(p1, p3), w.allProducts());
        w.addProduct(p2);
        assertContentEqualsInOrder(List.of(p1, p2, p3), w.allProducts());

        System.out.println(w.allProducts());
        System.out.println(w.allNames());
        assertContentEqualsInAnyOrder(Set.of(p1.getName(), p2.getName(), p3.getName()), w.allNames());

        // Changes to the returned set should not affect the warehouse
        final var modifiedProductSet = w.allProducts();
        modifiedProductSet.remove(p1);

        System.out.println(w.allNames());
        assertContentEqualsInAnyOrder(Set.of(p1.getName(), p2.getName(), p3.getName()), w.allNames());
        System.out.println(w.allProducts());
        assertContentEqualsInOrder(List.of(p1, p2, p3), w.allProducts());
        System.out.println(modifiedProductSet);
        assertContentEqualsInAnyOrder(List.of(p2, p3), modifiedProductSet);
    }

}
