package it.unibo.oop.lab09.workers1;

import java.util.List;

/**
 * This is a standard implementation of the calculation.
 * 
 * */

public class MultiThreadedListSum implements ISumList {

    private final int nthread;

    /**
     * 
     * @param nthread
     *            no. of thread performing the sum.
     */
    public MultiThreadedListSum(final int nthread) {
        this.nthread = nthread;
    }

    private static class Worker extends Thread {

        // Campi che identificano il lavoro che il singolo Worker deve eseguire
        private final List<Integer> list;
        private final int startpos;
        private final int nelem;
        // Risultato della computazione
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
        public Worker(final List<Integer> list, final int startpos, final int nelem) {
            super();
            this.list = list;
            this.startpos = startpos;
            this.nelem = nelem;
        }

        @Override
        public void run() {
            // Esecuzione del singolo Worker
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
        long res = 0;

        // Genero un array di Worker e li faccio partire
        Worker[] w = new Worker[nthread];
        int start = 0;
        final int size = list.size() % nthread + list.size() / nthread;
        for (int j = 0; j < nthread; j++) {
            w[j] = new Worker(list, start, size);
            w[j].start();
            start = start + size;
        }
        // Attendo la fine di tutti i worker e recupero i risultati
        for (final Worker worker : w) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                System.out.println("Sum execution interrupted");
            }
            res += worker.getResult();
        }
        return res;
    }
}
