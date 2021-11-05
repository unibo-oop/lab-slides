package it.unibo.oop.lab05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public final class Assertions {
    private Assertions() { }

    public static void assertTrue(final boolean condition) {
        if (!condition) {
            System.err.println("ERROR: Was expecting true");
        }
    }

    public static void assertEquals(final Object expected, final Object actual) {
        if (!Objects.equals(expected, actual)) {
            onNotEquals(expected, actual);
        }
    }

    public static void assertContentEqualsInOrder(final Collection<?> expected, final Collection<?> actual) {
        if (actual == null || !new ArrayList<>(expected).equals(new ArrayList<>(actual))) {
            onNotEquals(expected, actual);
        }
    }

    public static void assertContentEqualsInAnyOrder(final Collection<?> expected, final Collection<?> actual) {
        if (!checkContentEqualsInAnyOrder(expected, actual)) {
            onNotEquals(expected, actual);
        }
    }

    private static boolean checkContentEqualsInAnyOrder(final Collection<?> expected, final Collection<?> actual) {
        if (actual == null || expected.size() != actual.size()) {
            return false;
        }
        final Collection<?> expectedCopy = new ArrayList<>(expected);
        for (var elem : actual) {
            if (!expectedCopy.remove(elem)) {
                return false;
            }
        }
        return expectedCopy.isEmpty();
    }

    private static void onNotEquals(final Object expected, final Object actual) {
        System.err.println("ERROR: expected " + expected + ", but got " + actual);
    }
}
