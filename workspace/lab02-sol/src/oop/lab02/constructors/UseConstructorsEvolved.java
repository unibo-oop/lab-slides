package oop.lab02.constructors;

public class UseConstructorsEvolved {

    public static void main(final String[] args) {
        /*
         * Creare un treno con numero di posti di default, come nel caso
         * precedente
         *
         * - serve a verificare la nuova implementazione di Train()
         */
        final Train t1 = new Train();
        t1.printTrainInfo();

        /*
         * Creare i seguenti treni usando il costruttore Train(int nFCSeats, int
         * nSCSeats)
         * 
         * - nFCSeats = 20; nSCSeats= 200;
         * 
         * - nFCSeats = 35; nSCSeats= 165;
         */
        final Train t2 = new Train(20, 200);
        t2.printTrainInfo();

        final Train t3 = new Train(35, 165);
        t3.printTrainInfo();
    }
}
