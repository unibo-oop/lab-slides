package oop.lab02.constructors;

public class Train {

    private static final int DEFAULT_N_FC_SEATS = 50;
    private static final int DEFAULT_N_SC_SEATS = 100;
    private static final int DEFAULT_TOT_SEATS = 150;
    private final int seats;
    private final int firstClassSeats;
    private final int secondClassSeats;
    private int firstClassReserved;
    private int secondClassReserved;

    public Train() {
        this(DEFAULT_TOT_SEATS, DEFAULT_N_FC_SEATS, DEFAULT_N_SC_SEATS);
    }

    public Train(final int nFCSeats, final int nSCSeats) {
        this(nFCSeats + nSCSeats, nFCSeats, nSCSeats);
    }

    public Train(final int nTotSeats, final int nFCSeats, final int nSCSeats) {
        this.seats = nTotSeats;
        this.firstClassSeats = nFCSeats;
        this.secondClassSeats = nSCSeats;
        this.firstClassReserved = 0;
        this.firstClassReserved = 0;
    }

    public void deleteAllReservations() {
        this.firstClassReserved = 0;
        this.secondClassReserved = 0;
    }

    public double getFirstClassOccupancyRatio() {
        return this.firstClassReserved * 100d / this.firstClassSeats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public int getSecondClassSeats() {
        return secondClassSeats;
    }

    public double getOccupancyRatio() {
        return (this.firstClassReserved + this.secondClassReserved) * 100d / this.seats;
    }

    public double getSecondClassOccupancyRatio() {
        return this.secondClassReserved * 100 / this.secondClassSeats;
    }

    public int getTotalSeats() {
        return seats;
    }

    public void printTrainInfo() {
        System.out.println("Train info:\n-nTotSeats: " + this.seats);
        System.out.println("-nFCSeats: " + this.firstClassSeats);
        System.out.println("-nSCSeats: " + this.secondClassSeats);
        System.out.println("-nFCReservedSeats: " + this.firstClassReserved);
        System.out.println("-nSCReservedSeats: " + this.secondClassReserved + "\n");
    }

    public void reserveFirstClassSeats(final int nSeats) {
        this.firstClassReserved += nSeats;
    }

    public void reserveSecondClassSeats(final int nSeats) {
        this.secondClassReserved += nSeats;
    }
}
