package oop.lab02.arrays;

public class SeqRecognizer {

    private SeqRecognizer() {
    }

    public static boolean checkSeq1(final int[] array) {
        int i = 0;
        for (; i < array.length && array[i] == 1; i++);
        for (; i < array.length && (array[i] == 2 || array[i] == 3); i++);
        return i == array.length;
    }

    public static boolean checkSeq2(final int[] array) {
        if (array.length >= 2 && array[0] == 1 && array[array.length - 1] == 3) {
            int i = 1;
            for (; i < array.length - 1 && array[i] == 2; i++);
            return i == array.length - 1;
        }
        return false;
    }

    public static boolean checkSeq3(final int[] array) {
        if (array.length >= 2 && array[0] == 1) {
            int i = 1;
            for (; i < array.length - 1 && array[i] == 2; i++);
            if (array[i] == 3) {
                for (i++; i < array.length && array[i] == 4; i++);
                return i == array.length || i == array.length - 1 && array[array.length - 1] == 5;
            }
        }
        return false;
    }

    public static boolean checkSeq4(final int[] array) {
        if (array.length >= 1) {
            int index = 0;
            if (array[0] == 2 || array[0] == 3) {
                index = 1;
            }
            for (; index < array.length - 1 && array[index] == 4; index++);
            return index == array.length - 1 && array[index] == 5;
        } else {
            return false;
        }
    }

    /** Testing methods **/

    /* Utility method for testing checkSeq1 method */
    public static boolean testCheckSeq1() {
        return checkSeq1(new int[] { 1, 1 })
                && checkSeq1(new int[] { 1, 1, 1, 2 })
                && checkSeq1(new int[] { 1, 1, 1, 2, 3, 2, 3 })
                && !checkSeq1(new int[] { 1, 1, 1, 2, 3, 1, 3 })
                && !checkSeq1(new int[] { 3, 2, 1, 1 });
    }

    /* Utility method for testing checkSeq2 method */
    public static boolean testCheckSeq2() {
        return checkSeq2(new int[] { 1, 3 })
                && checkSeq2(new int[] { 1, 2, 3 })
                && checkSeq2(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && !checkSeq2(new int[] { 1, 2, 2 })
                && !checkSeq2(new int[] { 2, 2, 2, 2, 3 });
    }

    /* Utility method for testing checkSeq3 method */
    public static boolean testCheckSeq3() {
        return checkSeq3(new int[] { 1, 3 })
                && checkSeq3(new int[] { 1, 3, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 })
                && checkSeq3(new int[] { 1, 2, 3, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5 })
                && checkSeq3(new int[] { 1, 2, 2, 2, 3 })
                && !checkSeq3(new int[] { 1, 2, 2, 2 })
                && !checkSeq3(new int[] { 2, 2, 3, 4, 4, 4 })
                && !checkSeq3(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 6 });
    }

    public static void main(final String[] args) {
        System.out.println("testCheckSeq1: " + testCheckSeq1());
        System.out.println("testCheckSeq2: " + testCheckSeq2());
        System.out.println("testCheckSeq3: " + testCheckSeq3());
    }
}
