package it.unibo.oop.lab.workers02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Implement SumMatrix, which sums the elements of a matrix, with a class
 * MultiThreadedSumMatrix, that gets the job done in a multithreaded
 * fashion. Use the previous exercise as an example.
 * 
 * Split the work as equally as possible.
 */
public class TestMatrix {

    private static final int SIZE = 10000;
    private static final double EXPECTED_DELTA = 0.01;
    private static final String MSEC = " msec";

    /**
     * Base test for a multithreaded matrix sum.
     */
    @Test
    public void testBasic() {
        double sum = 0;
        final double[][] matrix = new double[SIZE][SIZE];
        for (double[] d : matrix) {
            for (int i = 0; i < SIZE; i++) {
                d[i] = i;
                sum += i;
            }
        }

        System.out.println("BTW: the sum with " + SIZE + "*" + SIZE + " elements is: " + sum);
        long time;

        SumMatrix sumMatrix = null; // new MultiThreadedSumMatrix(1);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 1 thread: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = null; // new MultiThreadedSumMatrix(3);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 3 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = null; // new MultiThreadedSumMatrix(7);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 7 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = null; // new MultiThreadedSumMatrix(10);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 10 threads: " + (System.currentTimeMillis() - time) + MSEC);
    }

}
