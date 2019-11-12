package it.unibo.oop.lab.workers01;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a standard implementation of the calculation.
 * 
 */
public final class MultiThreadedListSumClassic implements SumList {

    private final int nthread;

    /**
     * 
     * @param nthread
     *            no. of thread performing the sum.
     */
    public MultiThreadedListSumClassic(final int nthread) {
        this.nthread = nthread;
    }

    private static class Worker extends Thread {
        private final List<Integer> list;
        private final int startpos;
        private final int nelem;
        private long res;

        /**
         * Build a new worker.
         * 
         * @param list
         *            the list to sum
         * @param startpos
         *            the initial position for this worker
         * @param nelem
         *            the no. of elems to sum up for this worker
         */
        Worker(final List<Integer> list, final int startpos, final int nelem) {
            super();
            this.list = list;
            this.startpos = startpos;
            this.nelem = nelem;
        }

        @Override
        public void run() {
            System.out.println("Working from position " + startpos + " to position " + (startpos + nelem - 1));
            for (int i = startpos; i < list.size() && i < startpos + nelem; i++) {
                this.res += this.list.get(i);
            }
        }

        /**
         * Returns the risult of summing up the integers within the list.
         * 
         * @return the sum of every element in the array
         */
        public long getResult() {
            return this.res;
        }

    }

    @Override
    public long sum(final List<Integer> list) {
        final int size = list.size() % nthread + list.size() / nthread;
        /*
         * Build a list of workers
         */
        final List<Worker> workers = new ArrayList<>(nthread);
        for (int start = 0; start < list.size(); start += size) {
            workers.add(new Worker(list, start, size));
        }
        /*
         * Start them
         */
        for (final Worker w: workers) {
            w.start();
        }
        /*
         * Wait for every one of them to finish. This operation is _way_ better done by
         * using barriers and latches, and the whole operation would be better done with
         * futures.
         */
        long sum = 0;
        for (final Worker w: workers) {
            try {
                w.join();
                sum += w.getResult();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
        /*
         * Return the sum
         */
        return sum;
    }
}
