package oop.lab02.constructors;

public class Train {

    int nTotSeats;
    int nFCSeats;
    int nSCSeats;

    int nFCReservedSeats;
    int nSCReservedSeats;

    void build(final int nTotSeats, final int nFCSeats, final int nSCSeats) {
        this.nTotSeats = nTotSeats;
        this.nFCSeats = nFCSeats;
        this.nSCSeats = nSCSeats;
        this.nFCReservedSeats = 0;
        this.nSCReservedSeats = 0;
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
        return this.nSCReservedSeats * 100d / this.nSCSeats;
    }

    void deleteAllReservations() {
        this.nFCReservedSeats = 0;
        this.nSCReservedSeats = 0;
    }
}
