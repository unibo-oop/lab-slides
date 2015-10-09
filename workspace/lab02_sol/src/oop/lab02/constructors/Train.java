package oop.lab02.constructors;

public class Train {

    private static final int DEFAULT_N_SC_SEATS = 100;
    private static final int DEFAULT_N_FC_SEATS = 50;
    private static final int DEFAULT_TOT_SEATS = 150;
    int nTotSeats;
    int nFCSeats;
    int nSCSeats;

    int nFCReservedSeats;
    int nSCReservedSeats;

    public Train(final int nTotSeats, final int nFCSeats, final int nSCSeats) {
        this.nTotSeats = nTotSeats;
        this.nFCSeats = nFCSeats;
        this.nSCSeats = nSCSeats;
        this.nFCReservedSeats = 0;
        this.nFCReservedSeats = 0;
    }

    public Train() {
        this.nTotSeats = DEFAULT_TOT_SEATS;
        this.nFCSeats = DEFAULT_N_FC_SEATS;
        this.nSCSeats = DEFAULT_N_SC_SEATS;
        this.nFCReservedSeats = 0;
        this.nFCReservedSeats = 0;
    }

    void reserveFCSeats(final int nSeats) {
        this.nFCReservedSeats += nSeats;
    }

    void reserveSCSeats(final int nSeats) {
        this.nSCReservedSeats += nSeats;
    }

    double getTotOccupancyRatio() {
        return (this.nFCReservedSeats + this.nSCReservedSeats) * 100d / this.nTotSeats;
    }

    double getFCOccupancyRatio() {
        return this.nFCReservedSeats * 100d / this.nFCSeats;
    }

    double getSCOccupancyRatio() {
        return this.nSCReservedSeats * 100 / this.nSCSeats;
    }

    void deleteAllReservations() {
        this.nFCReservedSeats = 0;
        this.nSCReservedSeats = 0;
    }

    public void printTrainInfo() {
        System.out.println("Train info:\n-nTotSeats: " + this.nTotSeats);
        System.out.println("-nFCSeats: " + this.nFCSeats);
        System.out.println("-nFCSeats: " + this.nSCSeats);
        System.out.println("-nFCReservedSeats: " + this.nFCReservedSeats);
        System.out.println("-nSCReservedSeats: " + this.nSCReservedSeats + "\n");
    }
}
