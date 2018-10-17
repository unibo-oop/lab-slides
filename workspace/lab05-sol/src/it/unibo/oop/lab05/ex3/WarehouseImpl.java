package it.unibo.oop.lab05.ex3;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of a warehouse.
 * 
 */
public class WarehouseImpl implements Warehouse {

    private final Set<Product> set = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    public final void addProduct(final Product p) {
        this.set.add(p);
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> allNames() {
        final Set<String> s = new HashSet<>();
        for (final Product p : this.set) {
            s.add(p.getName());
        }
        return s;
    }

    /**
     * {@inheritDoc}
     */
    public Set<Product> allProducts() {
        return new HashSet<>(this.set);
    }

    /**
     * {@inheritDoc}
     */
    public final boolean containsProduct(final Product p) {
        return set.contains(p);
    }

    /**
     * {@inheritDoc}
     */
    public final double getQuantity(final String name) {
        for (final Product p : this.set) {
            if (p.getName().equals(name)) {
                return p.getQuantity();
            }
        }
        return 0;
    }
}
