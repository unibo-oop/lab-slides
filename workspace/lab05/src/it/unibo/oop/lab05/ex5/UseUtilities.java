package it.unibo.oop.lab05.ex5;

import static it.unibo.oop.lab05.Assertions.assertEquals;

import java.util.Set;

/**
 * Simple the class to test {it.unibo.oop.lab05.Utilities} class.
 */
public final class UseUtilities {

    private UseUtilities() { }

    /**
     * @param s
     *            unused
     */
    public static void main(final String[] s) {
        final var setA = Set.of("a", "b", "c", "d");
        final var setB = Set.of("c", "d", "e");

        assertEquals(Set.of("a", "b", "c", "d", "e"), Utilities.setUnion(setA, setB));
        assertEquals(Set.of("c", "d"), Utilities.setIntersection(setA, setB));
        assertEquals(Set.of("a", "b", "e"), Utilities.setSymmetricDifference(setA, setB));

        for (int i = 0; i < 10; i++) {
            System.out.println("Random-extracting: " + Utilities.getRandomElement(setA));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Random-extracting: " + Utilities.getRandomPair(setA, setB));
        }
    }
}
