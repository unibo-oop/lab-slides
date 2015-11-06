package it.unibo.oop.lab05.ex2;

import java.util.Comparator;

/**
 * A comparator which expects two {@link String} parsable as {@link Double}
 * using {@link Double#parseDouble(String)}.
 * 
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public class MyStringComparator implements Comparator<String> {

    public int compare(final String o1, final String o2) {
        return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
    }

}