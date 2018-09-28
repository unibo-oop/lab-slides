package oop.lab02.constructors;

public class UseConstructors {

    public static void main(final String[] args) {
        /*
         * 1) Creare lo studente Mario Rossi, matricola 1014, anno
         * immatricolazione 2013
         */
        final Student marioRossi = new Student(1014, "Mario", "Rossi", 2013);
        marioRossi.printStudentInfo();

        /*
         * 2) Creare lo studente Luca Bianchi, matricola 1018, anno
         * immatricolazione 2010
         */
        final Student lucaBianchi = new Student(1018, "Luca", "Bianchi", 2010);
        lucaBianchi.printStudentInfo();

        /*
         * 3) Creare lo studente Peppino Vitiello, matricola 1019, anno
         * immatricolazione 2012
         */
        final Student peppinoVitiello = new Student(1019, "Peppino", "Vitiello", 2012);
        peppinoVitiello.printStudentInfo();

        /*
         * 4) Creare lo studente Luca Verdi, matricola 1020, anno
         * immatricolazione 2013
         */
        final Student lucaVerdi = new Student(1020, "Luca", "Verdi", 2013);
        lucaVerdi.printStudentInfo();

        /*
         * 5) Creare un treno con 300 posti di cui 100 in prima classe 200 in
         * seconda classe
         */
        final Train t1 = new Train(300, 100, 200);
        t1.printTrainInfo();

        /*
         * 6) Creare un treno con 1200 posti di cui 50 in prima classe 1050 in
         * seconda classe
         */
        final Train t2 = new Train(1200, 50, 1050);
        t2.printTrainInfo();

        /*
         * 7) Creare un treno con 500 posti, tutti di seconda classe
         */
        final Train t3 = new Train(500, 0, 500);
        t3.printTrainInfo();

        /*
         * 8) Creare un treno con numero di posti di default
         */
        final Train t4 = new Train();
        t4.printTrainInfo();
        System.out.println(t4.getTotalSeats() > 0 ? "OK!" : "There is a bug.");
        System.out.println(t4.getTotalSeats() == t4.getFirstClassSeats() + t4.getSecondClassSeats() ? "OK!" : "There is a bug.");
    }
}
