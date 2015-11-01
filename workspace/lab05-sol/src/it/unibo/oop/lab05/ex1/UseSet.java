package it.unibo.oop.lab05.ex1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Example class using {@link Set}.
 * 
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param s
     *            ignored
     */
    public static void main(final String[] s) {

        /*
         * Considering the content of "UseCollection, write a program which, in
         * order: 1) Builds a TreeSet containing Strings 2) Populates such
         * Collection with all the Strings ranging from "1" to "20" 3) Prints
         * its content 4) Removes all those strings whose represented number is
         * divisible by three 5) Prints the content of the Set using a for-each
         * costruct 6) Verifies if all the numbers left in the set are even
         */

        final Set<String> set = new TreeSet<>();
        for (int i = 1; i <= ELEMS; i++) {
            set.add(Integer.toString(i));
        }
        System.out.println(set);
        for (int i = 3; i <= ELEMS; i += 3) {
            set.remove(Integer.toString(i));
        }
        for (final String str : set) {
            System.out.print(str + " | ");
        }
        System.out.println();
        final Set<String> set2 = new TreeSet<>();
        for (int i = 2; i <= ELEMS; i += 2) {
            set2.add(Integer.toString(i));
        }
        System.out.println(set2);
        System.out.println(set.containsAll(set2));

    }
}
