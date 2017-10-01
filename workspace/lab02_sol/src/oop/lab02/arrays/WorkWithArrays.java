package oop.lab02.arrays;

import java.util.Arrays;

public class WorkWithArrays {

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
        final int resultLength = array.length % 2 == 0 ? array.length / 2  : array.length / 2 + 1;
        final int[] resultArray = new int[resultLength];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                resultArray[j++] = array[i];
            }
        }
        return resultArray;
    }

    public static int[] oddElems(final int[] array) {
        final int[] resultArray = new int[array.length / 2];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                resultArray[j++] = array[i];
            }
        }
        return resultArray;
    }

    public static int getMostRecurringElem(final int[] array) {
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
                if ((desc && array[i] < array[i + 1]) || (!desc && array[i] > array[i + 1])) { // descending sort || ascending sort
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

    public static int[] dupElems(final int[] array, final int nTimes) {
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
    public static boolean testCountOccurr() {
        return countOccurr(new int[] { 1, 2, 3, 4 }, 1) == 1 && countOccurr(new int[] { 0, 2, 3, 4 }, 1) == 0
                && countOccurr(new int[] { 7, 4, 1, 9, 3, 1, 5 }, 2) == 0
                && countOccurr(new int[] { 1, 2, 1, 3, 4, 1 }, 1) == 3;
    }

    /* Utility method for testing evenElems method */
    public static boolean testEvenElems() {
        return arrayEquals(evenElems(new int[] { 1, 2, 3, 4 }), new int[] { 1, 3 })
                && arrayEquals(evenElems(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 1, 3, 5, 7, 9 })
                && arrayEquals(evenElems(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 4, 7, 1, 23, 73 })
                && arrayEquals(evenElems(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }), new int[] { 7, 1, 12, 23,
                        54 });
    }

    /* Utility method for testing oddElems method */
    public static boolean testOddElems() {
        return arrayEquals(oddElems(new int[] { 1, 2, 3, 4 }), new int[] { 2, 4 })
                && arrayEquals(oddElems(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), new int[] { 2, 4, 6, 8 })
                && arrayEquals(oddElems(new int[] { 4, 6, 7, 9, 1, 5, 23, 11, 73 }), new int[] { 6, 9, 5, 11 })
                && arrayEquals(oddElems(new int[] { 7, 5, 1, 24, 12, 46, 23, 11, 54, 81 }), new int[] { 5, 24, 46, 11,
                        81 });
    }

    /* Utility method for testing getMostRecurringElem method */
    public static boolean testGetMostRecurringElem() {
        return getMostRecurringElem(new int[] { 1, 2, 1, 3, 4 }) == 1
                && getMostRecurringElem(new int[] { 7, 1, 5, 7, 7, 9 }) == 7
                && getMostRecurringElem(new int[] { 1, 2, 3, 1, 2, 3, 3 }) == 3
                && getMostRecurringElem(new int[] { 5, 11, 2, 11, 7, 11 }) == 11;
    }

    /* Utility method for testing sortArray method */
    public static boolean testSortArray() {
        return arrayEquals(sortArray(new int[] { 3, 2, 1 }, false), new int[] { 1, 2, 3 })
                && arrayEquals(sortArray(new int[] { 1, 2, 3 }, true), new int[] { 3, 2, 1 })
                && arrayEquals(sortArray(new int[] { 7, 4, 1, 5, 9, 3, 5, 6 }, false), new int[] { 1, 3, 4, 5, 5, 6, 7,
                        9 });
    }

    /* Utility method for testing computeVariance method */
    public static boolean testComputeVariance() {
        return computeVariance(new int[] { 1, 2, 3, 4 }) == 1.25 && computeVariance(new int[] { 1, 1, 1, 1 }) == 0
                && computeVariance(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }) == 8.25;
    }

    /* Utility method for testing revertUpTo method */
    public static boolean testRevertUpTo() {
        return arrayEquals(revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5), new int[] { 5, 4, 3, 2, 1, 6, 7,
                8, 9, 10 })
                && arrayEquals(revertUpTo(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3), new int[] { 3, 2, 1, 4, 5,
                        6, 7, 8, 9, 10 })
                && arrayEquals(revertUpTo(new int[] { 1, 2, 3 }, 3), new int[] { 3, 2, 1 });
    }

    /* Utility method for testing dupElems method */
    public static boolean testDupElems() {
        return arrayEquals(dupElems(new int[] { 1, 2, 3 }, 2), new int[] { 1, 1, 2, 2, 3, 3 })
                && arrayEquals(dupElems(new int[] { 1, 2 }, 5), new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 });
    }

    /* Utility method used to check if two int arrays are equals */
    private static boolean arrayEquals(final int[] array1, final int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(final String[] args) {
        System.out.println("testCountOccurr: " + testCountOccurr());
        System.out.println("testEvenElems: " + testEvenElems());
        System.out.println("testOddElems: " + testOddElems());
        System.out.println("testGetMostRecurringElem: " + testGetMostRecurringElem());
        System.out.println("testSortArray: " + testSortArray());
        System.out.println("testComputeVariance: " + testComputeVariance());
        System.out.println("testRevertUpTo: " + testRevertUpTo());
        System.out.println("testDupElems: " + testDupElems());
    }
}
