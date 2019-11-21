package it.unibo.oop.lab.workers02;

import java.util.stream.IntStream;

/**
 * This is a standard implementation of the calculation.
 * 
 */

public class MultiThreadedSumMatrixWithStreams implements SumMatrix {

    private final int nthread;

    /**
     * Construct a multithreaded matrix sum.
     * 
     * @param nthread
     *            no. threads to be adopted to perform the operation
     */
    public MultiThreadedSumMatrixWithStreams(final int nthread) {
        super();
        if (nthread < 1) {
            throw new IllegalArgumentException();
        }
        this.nthread = nthread;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double sum(final double[][] matrix) {
        final int size = matrix.length / nthread + matrix.length % nthread;
        /*
         * Parallel pipeline processing
         */
        return IntStream.iterate(0, start -> start + size)
                .limit(nthread)
                /*
                 * We do not create thread ourselves. We decide how tasks should be done, and we
                 * ask the Stream library to spawn the required threads.
                 */
                .parallel()
                .mapToDouble(start -> {
                    double result = 0;
                    for (int i = start; i < matrix.length && i < start + size; i++) {
                        for (final double d : matrix[i]) {
                            result += d;
                        }
                    }
                    return result;
                })
                .sum();
    }
}
