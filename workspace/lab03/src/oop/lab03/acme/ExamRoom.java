package oop.lab03.acme;

public class ExamRoom {
    private int nSeats;
    private String description;
    private boolean isProjectorAvailable;
    private boolean isNetworkAvailable;

    public ExamRoom(int nSeats, String description, boolean isProjectorAvailable, boolean isNetworkAvailable) {
        this.nSeats = nSeats;
        this.description = description;
        this.isProjectorAvailable = isProjectorAvailable;
        this.isNetworkAvailable = isNetworkAvailable;
    }

    public int getnSeats() {
        return nSeats;
    }

    public String getDescription() {
        return description;
    }

    public boolean isProjectorAvailable() {
        return isProjectorAvailable;
    }

    public boolean isNetworkAvailable() {
        return isNetworkAvailable;
    }

    public String toString() {
        return "ExamRoom [nSeats=" + this.nSeats + ", description=" + this.description + ", isProjectorAvailable="
                + this.isProjectorAvailable + ", isNetworkAvailable=" + this.isNetworkAvailable + "]";
    }
}
