package it.unibo.oop.lab09.workers2;

import java.util.Arrays;

/**
 * This is a standard implementation of the calculation.
 * 
 * @author mviroli
 * @author mcasadei
 * 
 */

public class MultiThreadedSumMatrix implements ISumMatrix {

    private final int nthread;

    /**
     * Construct a multithreaded matrix sum.
     * 
     * @param nthread
     *            no. threads to be adopted to perform the operation
     */
    public MultiThreadedSumMatrix(final int nthread) {
        super();
        this.nthread = nthread;
    }

    private class Worker extends Thread {

        private final double[][] matrix;
        private final int startpos;
        private final int nelem;
        private double res;

        /**
         * Builds a new worker.
         * 
         * @param matrix
         *            the matrix to be summed
         * @param startpos
         *            the start position for the sum in charge to this worker
         * @param nelem
         *            the no. of element for him to sum
         */
        public Worker(final double[][] matrix, final int startpos, final int nelem) {
            super();
            this.matrix = Arrays.copyOf(matrix, matrix.length);
            this.startpos = startpos;
            this.nelem = nelem;
        }

        @Override
        public void run() {
            // System.out.println("Working from row "+startpos+" to row "+(startpos+nelem-1));
            for (int i = startpos; i < matrix.length && i < startpos + nelem; i++) {
                for (final double d : this.matrix[i]) {
                    this.res += d;
                }
            }
        }

        public double getResult() {
            return this.res;
        }

    }

    /**
     * Global sum fo the matrix.
     * 
     * @param matrix
     *            the matrix to be summed.
     * 
     * @return the sum of the matrix elements
     */
    public double sum(final double[][] matrix) {
        double res = 0;
        Worker[] w = new Worker[nthread];
        int start = 0;
        final int size = matrix.length % nthread == 0 ? matrix.length / nthread : matrix.length / nthread + 1;
        for (int j = 0; j < nthread; j++) {
            w[j] = new Worker(matrix, start, size);
            w[j].start();
            start = start + size;
        }
        for (final Worker worker : w) {
            try {
                worker.join();
            } catch (InterruptedException e) {
            }
            res += worker.getResult();
        }
        return res;
    }
}
