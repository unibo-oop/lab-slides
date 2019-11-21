package it.unibo.oop.lab.workers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * This is a standard implementation of the calculation.
 * 
 */

public class MultiThreadedSumMatrixWithFutures implements SumMatrix {

    private final int nthread;

    /**
     * Construct a multithreaded matrix sum.
     * 
     * @param nthread
     *            no. threads to be adopted to perform the operation
     */
    public MultiThreadedSumMatrixWithFutures(final int nthread) {
        super();
        if (nthread < 1) {
            throw new IllegalArgumentException();
        }
        this.nthread = nthread;
    }

    private class Worker implements Callable<Double> {

        private final double[][] matrix;
        private final int startpos;
        private final int nelem;

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
        public Double call() {
            double result = 0;
            for (int i = startpos; i < matrix.length && i < startpos + nelem; i++) {
                for (final double d : this.matrix[i]) {
                    result += d;
                }
            }
            return result;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double sum(final double[][] matrix) {
        final int size = matrix.length / nthread + matrix.length % nthread;
        /*
         * This kind of execution requires at least two control flows, or it will
         * inevitably lead to deadlock (the outermost work occupies the executor, but
         * requires the innermost workers to get scheduled and complete).
         * 
         * When there are many, possibly interdependent small tasks that need to be
         * executed in parallel, a good choice is using a fork-join thread pool.
         */
        final var executor = ForkJoinPool.commonPool();
        final Collection<Future<Double>> futureResults = new ArrayList<>(nthread);
        final var futureFinalResult = executor.submit(() -> {
            for (int start = 0; start < matrix.length; start += size) {
                futureResults.add(executor.submit(new Worker(matrix, start, size)));
            }
            double sum = 0;
            for (final Future<Double> result: futureResults) {
                sum += result.get();
            }
            executor.shutdown();
            return sum;
        });
        try {
            return futureFinalResult.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }
}
