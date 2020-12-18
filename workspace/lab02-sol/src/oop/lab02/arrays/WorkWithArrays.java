package oop.lab02.arrays;

import java.util.Arrays;

public class WorkWithArrays {

    private WorkWithArrays() {
    }

    public static int countOccurrencies(final int[] array, final int elem) {
        int nOccur = 0;
        for (final int currElem : array) {
            if (currElem == elem) {
                nOccur++;
            }
        }
        return nOccur;
    }

    public static int[] evenElements(final int[] array) {
        final int resultLength = array.length % 2 == 0 ? array.length / 2  : array.length / 2 + 1;
        final int[] resultArray = new int[resultLength];
        for (int i = 0; i < array.length; i += 2) {
            resultArray[i / 2] = array[i];
        }
        return resultArray;
    }

    public static int[] oddElements(final int[] array) {
        final int[] resultArray = new int[array.length / 2];
        for (int i = 1; i < array.length; i += 2) {
            resultArray[i / 2] = array[i];
        }
        return resultArray;
    }

    public static int mostRecurringElement(final int[] array) {
        int maxNumOccur = 0;
        int currMostRecurring = 0;
        final int[] temp = Arrays.copyOf(array, array.length);
        Arrays.sort(temp);
        /*
        * The Arrays.sort(...) method modifies its input array.
        * Modifying some method input array if considered a bad practice.
        * To avoid this, we will sort the `temp` array which is actually
        * a clone of this method input array.
        */
        for (int i = 0; i < temp.length;) {
            final int curr = temp[i];
            int numOccur = 0;
            for (i++; i < temp.length && temp[i] == curr; i++, numOccur++);
            if (numOccur > maxNumOccur) {
                maxNumOccur = numOccur;
                currMostRecurring = curr;
            }
        }
        return currMostRecurring;
    }

    public static int[] sortArray(final int[] array, final boolean desc) {
        boolean swap = true;
        int temp;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                // Descending || Ascending
                if ((desc && array[i] < array[i + 1]) || (!desc && array[i] > array[i + 1])) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }
        return array;
    }

    public static double computeVariance(final int[] array) {
        double returnValue = 0;
        double mean = 0;
        for (final int elem : array) {
            mean += elem;
        }
        mean /= array.length;
        for (final int elem : array) {
            returnValue += Math.pow(elem - mean, 2);
        }
        returnValue /= array.length;
        return returnValue;
    }

    public static int[] revertUpTo(final int[] array, final int elem) {
        int elemPos = 0;
        final int[] returnValue = new int[array.length];
        for (; elemPos < array.length && array[elemPos] != elem; elemPos++);
        int i = 0;
        for (; i <= elemPos; i++) {
            returnValue[i] = array[elemPos - i];
        }
        for (; i < array.length; i++) {
            returnValue[i] = array[i];
        }
        return returnValue;
    }

    public static int[] duplicateElements(final int[] array, final int nTimes) {
        final int[] returnValue = new int[array.length * nTimes];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < nTimes; j++) {
                returnValue[i * nTimes + j] = array[i];
            }
        }
        return returnValue;
    }

    /** Testing methods **/

    /* Utility method for testing countOccurr method */
    public static boolean testCountOccurrencies() {
        return countOccurrencies(new int[] { 1, 2, 3, 4 }, 1) == 1
                && countOccurrencies(new int[] { 0, 2, 3, 4 }, 1) == 0
                && countOccurrencies(new int[] { 7, 4, 1, 9, 3, 1, 5 }, 2) == 0
                && countOccurrencies(new int[] { 1, 2, 1, 3, 4, 1 }, 1) == 3;
    }

    /* Utility method for testing evenElems method */
    public static boolean testEvenElements() {
        return Arrays.equals(evenElements(new int[] { 1, 2, 3, 4 }), new int[] { 1, 3 })
                && Arrays.equals(evenElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 1, 3, 5, 7, 9 })
                && Arrays.equals(evenElements(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 4, 7, 1, 23, 73 })
                && Arrays.equals(
                    evenElements(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }),
                    new int[] { 7, 1, 12, 23, 54 });
    }

    /* Utility method for testing oddElems method */
    public static boolean testOddElements() {
        return Arrays.equals(oddElements(new int[] { 1, 2, 3, 4 }), new int[] { 2, 4 })
                && Arrays.equals(oddElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 2, 4, 6, 8 })
                && Arrays.equals(oddElements(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 6, 9, 5, 11 })
                && Arrays.equals(
                    oddElements(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }),
                    new int[] { 5, 24, 46, 11, 81 });
    }

    /* Utility method for testing getMostRecurringElem method */
    public static boolean testMostRecurringElement() {
        return mostRecurringElement(new int[] { 1, 2, 1, 3, 4 }) == 1
                && mostRecurringElement(new int[] { 7, 1, 5, 7, 7, 9 }) == 7
                && mostRecurringElement(new int[] { 1, 2, 3, 1, 2, 3, 3 }) == 3
                && mostRecurringElement(new int[] { 5, 11, 2, 11, 7, 11 }) == 11;
    }

    /* Utility method for testing sortArray method */
    public static boolean testSortArray() {
        return Arrays.equals(sortArray(new int[] { 3, 2, 1 }, false), new int[] { 1, 2, 3 })
                && Arrays.equals(sortArray(new int[] { 1, 2, 3 }, true), new int[] { 3, 2, 1 })
                && Arrays.equals(
                    sortArray(new int[] { 7, 4, 1, 5, 9, 3, 5, 6 }, false),
                    new int[] { 1, 3, 4, 5, 5, 6, 7, 9 });
    }

    /* Utility method for testing computeVariance method */
    public static boolean testComputeVariance() {
        return computeVariance(new int[] { 1, 2, 3, 4 }) == 1.25
                && computeVariance(new int[] { 1, 1, 1, 1 }) == 0
                && computeVariance(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }) == 8.25;
    }

    /* Utility method for testing revertUpTo method */
    public static boolean testRevertUpTo() {
        return Arrays.equals(
                    revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5),
                    new int[] { 5, 4, 3, 2, 1, 6, 7, 8, 9, 10 })
                && Arrays.equals(
                    revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3),
                    new int[] { 3, 2, 1, 4, 5, 6, 7, 8, 9, 10 })
                && Arrays.equals(
                    revertUpTo(new int[] { 1, 2, 3 }, 3),
                    new int[] { 3, 2, 1 });
    }

    /* Utility method for testing dupElems method */
    public static boolean testDuplicateElements() {
        return Arrays.equals(duplicateElements(new int[] { 1, 2, 3 }, 2), new int[] { 1, 1, 2, 2, 3, 3 })
                && Arrays.equals(duplicateElements(new int[] { 1, 2 }, 5), new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 });
    }

    public static void main(final String[] args) {
        System.out.println("testCountOccurr: " + testCountOccurrencies());
        System.out.println("testEvenElems: " + testEvenElements());
        System.out.println("testOddElems: " + testOddElements());
        System.out.println("testGetMostRecurringElem: " + testMostRecurringElement());
        System.out.println("testSortArray: " + testSortArray());
        System.out.println("testComputeVariance: " + testComputeVariance());
        System.out.println("testRevertUpTo: " + testRevertUpTo());
        System.out.println("testDupElems: " + testDuplicateElements());
    }
}
