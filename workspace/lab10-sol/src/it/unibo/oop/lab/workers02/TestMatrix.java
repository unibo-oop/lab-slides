package it.unibo.oop.lab.workers02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * TestMatrix for worker 2.
 *
 */
public class TestMatrix {

    /*
     * Si fornisce l'interfaccia ISumMatrix, con un metodo per calcolare la
     * somma delgi elementi di una matrice.
     * 
     * Realizzare una classe MultiThreadedSumMatrix, con costrutto che accetta
     * un intero positivo 'n', che implementa tale funzionalità in modo
     * "multi-threaded", con 'n' Worker che si dividano il compito in modo
     * sufficientemente omogeneo -- non è necessario che l'ammontare dei compiti
     * dei singoli Worker siano esattamente equivalenti.
     * 
     * Si faccia stampare (su System.out) ad ogni Worker una indicazione di che
     * porzione del lavoro svolge.
     * 
     * All'esecuzione del test qui sotto, le chiamate dovranno dare lo stesso
     * output, ad eccezione ovviamente dei tempi.
     */

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

        SumMatrix sumMatrix = new MultiThreadedSumMatrix(1);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 1 thread: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = new MultiThreadedSumMatrix(3);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 3 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = new MultiThreadedSumMatrix(8);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 8 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumMatrix = new MultiThreadedSumMatrix(10);
        time = System.currentTimeMillis();
        assertEquals(sumMatrix.sum(matrix), sum, EXPECTED_DELTA);
        System.out.println("Tried with 10 threads: " + (System.currentTimeMillis() - time) + MSEC);
    }

}
