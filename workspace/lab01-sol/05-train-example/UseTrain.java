class UseTrain {
  public static void main(String[] args) {
      /*
       * 1) Creare un oggetto della classe Train
       */
      Train train = new Train();
      train.build(50, 100);

      /*
       * 2) Effettuare delle prenotazioni in prima e seconda classe
       * specificando un numero di posti da prenotare consistente
       */
      train.reserveFirstClassSeats(10);
      train.reserveSecondClassSeats(30);

      /*
       * 3) A seguito di ciascuna prenotazione stampare la ratio di
       * occupazione totale e per ciascuna classe.
       */
      System.out.println("Total occupancy ration: " + train.getTotOccupancyRatio() + "%");
      System.out.println("First class occupancy ratio: " + train.getFirstClassOccupancyRatio() + "%");
      System.out.println("Second class occupancy ratio: " + train.getSecondClassOccupancyRatio() + "%\n");

      /*
       * 4) Cancellare tutte le prenotazioni
       */
      train.deleteAllReservations();
      System.out.println("Cleared all reservations.\n");

      /*
       * 5) Prenotare nuovamente dei posti e stampare le nuove percentuali di
       * occupazione
       */
      train.reserveFirstClassSeats(25);
      train.reserveSecondClassSeats(100);
      System.out.println("Total occupancy ration: " + train.getTotOccupancyRatio() + "%");
      System.out.println("First class occupancy ratio: " + train.getFirstClassOccupancyRatio() + "%");
      System.out.println("Second class occupancy ratio: " + train.getSecondClassOccupancyRatio() + "%\n");
  }
}
