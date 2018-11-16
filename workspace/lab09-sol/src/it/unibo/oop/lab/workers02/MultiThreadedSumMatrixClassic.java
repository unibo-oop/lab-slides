package it.unibo.oop.lab.workers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a standard implementation of the calculation.
 * 
 */

public class MultiThreadedSumMatrixClassic implements SumMatrix {

    private final int nthread;

    /**
     * Construct a multithreaded matrix sum.
     * 
     * @param nthread
     *            no. threads to be adopted to perform the operation
     */
    public MultiThreadedSumMatrixClassic(final int nthread) {
        super();
        if (nthread < 1) {
            throw new IllegalArgumentException();
        }
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
        Worker(final double[][] matrix, final int startpos, final int nelem) {
            super();
            this.matrix = Arrays.copyOf(matrix, matrix.length);
            this.startpos = startpos;
            this.nelem = nelem;
        }

        @Override
        public void run() {
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
     * {@inheritDoc}
     */
    @Override
    public double sum(final double[][] matrix) {
        final int size = matrix.length / nthread + matrix.length % nthread;
        final List<Worker> workers = new ArrayList<>(nthread);
        for (int start = 0; start < matrix.length; start += size) {
            workers.add(new Worker(matrix, start, size));
        }
        for (final Thread worker: workers) {
            worker.start();
        }
        double sum = 0;
        for (final Worker worker: workers) {
            try {
                worker.join();
                sum += worker.getResult();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
        return sum;
    }
}
