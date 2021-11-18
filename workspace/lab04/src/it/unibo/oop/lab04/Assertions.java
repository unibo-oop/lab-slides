package it.unibo.oop.lab04;

public final class Assertions {
    private Assertions() { }

    public static void assertEquals(final String propertyName, final Object expected, final Object actual) {
        if (actual == null || !actual.equals(expected)) {
            onWrong(propertyName, expected, actual);
        } else {
            onCorrect(propertyName, actual);
        }
    }

    public static void assertEquals(final String propertyName, final double expected, final double actual, final double delta) {
        if (Math.abs(actual - expected) > delta) {
            onWrong(propertyName, expected, actual);
        } else {
            onCorrect(propertyName, actual);
        }
    }

    public static void assertEquals(final String propertyName, final int expected, final int actual) {
        if (expected != actual) {
            onWrong(propertyName, expected, actual);
        } else {
            onCorrect(propertyName, actual);
        }
    }

    private static void onWrong(final String propertyName, final Object expected, final Object actual) {
        System.err.println(propertyName + " was expected to be " + expected + ", but it yields " + actual + " (ERROR!)");
    }

    private static void onCorrect(final String propertyName, final Object actual) {
        System.out.println(propertyName + ": " + actual + " (CORRECT)");
    }
}
