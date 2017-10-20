package it.unibo.oop.lab05.ex5;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

/**
 * 
 * Simple the class to test {it.unibo.oop.lab05.Utilities} class.
 * 
 */
public final class UseUtilities {

    private UseUtilities() { }

    /**
     * @param s
     *            unused
     */
    public static void main(final String[] s) {
        /*
         * Implement methods in Utilities in such a way that this test runs
         * correctly.
         */
        final Collection<String> c = new TreeSet<>(Arrays.asList("a", "b", "c", "d"));
        final Collection<String> c2 = new TreeSet<>(Arrays.asList("e", "f"));
        System.out.println(c);
        System.out.println(c2);
        Utilities.copyAll(c, c2);
        System.out.println(c);
        System.out.println(c2);
        for (int i = 0; i < 10; i++) {
            System.out.println("Random-extracting: " + Utilities.getRandomElement(c));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Random-extracting pair: " + Utilities.getRandomPair(c, c2));
        }
    }
}
