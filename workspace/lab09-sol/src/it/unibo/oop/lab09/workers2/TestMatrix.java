package it.unibo.oop.lab09.workers2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMatrix {

    /*
     * Si fornisce l'interfaccia ISumMatrix, con un metodo per calcolare la
     * somma delgi elementi di una matrice Realizzare una classe
     * MultiThreadedSumMatrix, con costrutto che accetta un intero positivo 'n',
     * che implementa tale funzionalità in modo "multi-threaded", con 'n' Worker
     * che si dividano il compito in modo sufficientemente omogeneo -- non è
     * necessario che l'ammontare dei compiti dei singoli Worker siano
     * esattamente equivalenti. Si faccia stampare (su System.out) ad ogni
     * Worker una indicazione di che porzione del lavoro svolge.
     * 
     * All'esecuzione del test qui sotto, le chiamate dovranno dare lo stesso
     * output, ad eccezione ovviamente dei tempi.
     */

    private static final int SIZE = 10000;

    /**
     * Basic test.
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

        time = System.currentTimeMillis();
        assertEquals(new MultiThreadedSumMatrix(1).sum(matrix), sum, 0.01);
        System.out.println("Tried with 1 thread: " + (System.currentTimeMillis() - time) + " msec");
        time = System.currentTimeMillis();
        assertEquals(new MultiThreadedSumMatrix(3).sum(matrix), sum, 0.01);
        System.out.println("Tried with 3 threads: " + (System.currentTimeMillis() - time) + " msec");
        time = System.currentTimeMillis();
        assertEquals(new MultiThreadedSumMatrix(7).sum(matrix), sum, 0.01);
        System.out.println("Tried with 7 threads: " + (System.currentTimeMillis() - time) + " msec");
        time = System.currentTimeMillis();
        assertEquals(new MultiThreadedSumMatrix(10).sum(matrix), sum, 0.01);
        System.out.println("Tried with 10 threads: " + (System.currentTimeMillis() - time) + " msec");
    }

}
