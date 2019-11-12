package it.unibo.oop.lab.workers01;

import java.util.List;
import java.util.stream.IntStream;

/**
 * This is an implementation using streams.
 * 
 */
public final class MultiThreadedListSumWithStreams implements SumList {

    private final int nthread;

    /**
     * 
     * @param nthread
     *            no. of thread performing the sum.
     */
    public MultiThreadedListSumWithStreams(final int nthread) {
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
         * Build a stream of workers
         */
        return IntStream.iterate(0, start -> start + size)
                .limit(nthread)
                .mapToObj(start -> new Worker(list, start, size))
                // Start them
                .peek(Thread::start)
                // Join them
                .peek(MultiThreadedListSumWithStreams::joinUninterruptibly)
                 // Get their result and sum
                .mapToLong(Worker::getResult)
                .sum();
    }

    private static void joinUninterruptibly(final Thread target) {
        var joined = false;
        while (!joined) {
            try {
                target.join();
                joined = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
