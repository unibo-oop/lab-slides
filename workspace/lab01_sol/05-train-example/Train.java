class Train {
    int nTotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build(int nFirstClassSeats, int nSecondClassSeats) {
        this.nTotSeats = nFirstClassSeats + nSecondClassSeats;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }

    void reserveFirstClassSeats(int nSeats) {
        nFirstClassReservedSeats += nSeats;
    }

    void reserveSecondClassSeats(int nSeats) {
        nSecondClassReservedSeats += nSeats;
    }

    double getTotOccupancyRatio() {
        return (nFirstClassReservedSeats + nSecondClassReservedSeats) * 100.0 / nTotSeats;
    }

    double getFirstClassOccupancyRatio() {
        return nFirstClassReservedSeats * 100.0d / nFirstClassSeats;
    }

    double getSecondClassOccupancyRatio() {
        return nSecondClassReservedSeats * 100d / nSecondClassSeats;
    }

    void deleteAllReservations() {
        nFirstClassReservedSeats = 0;
        nSecondClassReservedSeats = 0;
    }
}
