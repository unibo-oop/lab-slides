package oop.lab02.arrays;

public class WorkWithArrays {

    /*
    * ADVICE:
    * If your method implements an algorithm, it doesn't necessarly need to contain
    * the whole code! You can decomopose your problem into simpler (non-trivial) ones,
    * writing a *private* utility method for each sub problem.
    * Moreover, if your utility method solves a common sub-problem, it may be
    * re-used by other methods within the same class.
    */


    public static int countOccurr(final int[] array, final int elem) {
        int nOccur = 0;
        for (final int currElem : array) {
            if (currElem == elem) {
                nOccur++;
            }
        }
        return nOccur;
    }

    public static int[] evenElems(final int[] array) {
        return new int[] {};
    }

    public static int[] oddElems(final int[] array) {
        return new int[] {};
    }

    public static int getMostRecurringElem(final int[] array) {
        return 0;
    }

    /** Testing methods **/

    /*
     * Utility method for testing countOccurr method
     */
    public static boolean testCountOccurr() {
        return countOccurr(new int[] { 1, 2, 3, 4 }, 1) == 1
                && countOccurr(new int[] { 0, 2, 3, 4 }, 1) == 0
                && countOccurr(new int[] { 7, 4, 1, 9, 3, 1, 5 }, 2) == 0
                && countOccurr(new int[] { 1, 2, 1, 3, 4, 1 }, 1) == 3;
    }

    /*
     * Utility method for testing testEvenElems method
     */
    public static boolean testEvenElems() {
        return arrayEquals(evenElems(new int[] { 1, 2, 3, 4 }), new int[] { 1,
                3 })
                && arrayEquals(
                        evenElems(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }),
                        new int[] { 1, 3, 5, 7, 9 })
                && arrayEquals(evenElems(new int[] { 4, 6, 7, 9, 1, 5, 23, 11,
                        73 }), new int[] { 4, 7, 1, 23, 73 })
                && arrayEquals(evenElems(new int[] { 7, 5, 1, 24, 12, 46, 23,
                        11, 54, 81 }), new int[] { 7, 1, 12, 23, 54 });
    }

    /*
     * Utility method for testing testOddElems method
     */
    public static boolean testOddElems() {
        return arrayEquals(oddElems(new int[] { 1, 2, 3, 4 }),
                new int[] { 2, 4 })
                && arrayEquals(
                        oddElems(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }),
                        new int[] { 2, 4, 6, 8 })
                && arrayEquals(oddElems(new int[] { 4, 6, 7, 9, 1, 5, 23, 11,
                        73 }), new int[] { 6, 9, 5, 11 })
                && arrayEquals(oddElems(new int[] { 7, 5, 1, 24, 12, 46, 23,
                        11, 54, 81 }), new int[] { 5, 24, 46, 11, 81 });
    }

    /*
     * Utility method for testing testGetMostRecurringElem method
     */
    public static boolean testGetMostRecurringElem() {
        return getMostRecurringElem(new int[] { 1, 2, 1, 3, 4 }) == 1
                && getMostRecurringElem(new int[] { 7, 1, 5, 7, 7, 9 }) == 7
                && getMostRecurringElem(new int[] { 1, 2, 3, 1, 2, 3, 3 }) == 3
                && getMostRecurringElem(new int[] { 5, 11, 2, 11, 7, 11 }) == 11;
    }

    /*
     * Utility method used to check if two int arrays are equals
     */
    private static boolean arrayEquals(final int[] array1, final int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(final String[] args) {
        System.out.println("testCountOccurr: " + testCountOccurr());
        System.out.println("testEvenElems: " + testEvenElems());
        System.out.println("testOddElems: " + testOddElems());
        System.out.println("testGetMostRecurringElem: " + testGetMostRecurringElem());
    }
}
