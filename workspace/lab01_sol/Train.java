public class Train {
    int nTotSeats;
    int nFCSeats;
    int nSCSeats;
    int nFCReservedSeats;
    int nSCReservedSeats;

    void build(int nTotSeats, int nFCSeats, int nSCSeats) {
        this.nTotSeats = nTotSeats;
        this.nFCSeats = nFCSeats;
        this.nSCSeats = nSCSeats;
        this.nFCReservedSeats = 0;
        this.nFCReservedSeats = 0;
    }

    void reserveFCSeats(int nSeats) {
        nFCReservedSeats += nSeats;
    }

    void reserveSCSeats(int nSeats) {
        nSCReservedSeats += nSeats;
    }

    double getTotOccupancyRatio() {
        return ((double) (nFCReservedSeats + nSCReservedSeats) / nTotSeats) * 100;
    }

    double getFCOccupancyRatio() {
        return (((double) nFCReservedSeats) / nFCSeats) * 100;
    }

    double getSCOccupancyRatio() {
        return (((double) nSCReservedSeats) / nSCSeats) * 100;
    }

    void deleteAllReservations() {
        nFCReservedSeats = 0;
        nSCReservedSeats = 0;
    }
}
