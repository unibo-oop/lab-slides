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
		this.nFCReservedSeats = 0;
	}

	void reserveFCSeats(final int nSeats) {
		this.nFCReservedSeats += nSeats;
	}

	void reserveSCSeats(final int nSeats) {
		this.nSCReservedSeats += nSeats;
	}

	double getTotOccupancyRatio() {
		return ((double) (this.nFCReservedSeats + this.nSCReservedSeats) / this.nTotSeats) * 100;
	}

	double getFCOccupancyRatio() {
		return (((double) this.nFCReservedSeats) / this.nFCSeats) * 100;
	}

	double getSCOccupancyRatio() {
		return (((double) this.nSCReservedSeats) / this.nSCSeats) * 100;
	}

	void deleteAllReservations() {
		this.nFCReservedSeats = 0;
		this.nSCReservedSeats = 0;
	}
}
