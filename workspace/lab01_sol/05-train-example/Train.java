public class Train {
    int nTotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build(int nTotSeats, int nFirstClassSeats, int nSecondClassSeats) {
        this.nTotSeats = nTotSeats;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }

    void reserveFirstClassSeats(int nSeats) {
        nFirstClassSeats += nSeats;
    }

    void reserveSecondClassSeats(int nSeats) {
        nSecondClassReservedSeats += nSeats;
    }

    double getTotOccupancyRatio() {
        return ((double) (nFirstClassReservedSeats + nSecondClassReservedSeats) / nTotSeats) * 100;
    }

    double getFirstClassOccupancyRatio() {
        return (((double) nFirstClassReservedSeats) / nFirstClassSeats) * 100;
    }

    double getSecondClassOccupancyRatio() {
        return (((double) nSecondClassReservedSeats) / nSecondClassSeats) * 100;
    }

    void deleteAllReservations() {
        nFirstClassReservedSeats = 0;
        nSecondClassReservedSeats = 0;
    }
}
