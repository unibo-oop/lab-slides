/**
 * 
 */
package it.unibo.oop.lab06.exercise4;

/**
 * Represents an enumeration for declaring sports.
 * 
 * 1) You must add a field keeping track of the number of members each team is
 * composed of (1 for individual sports)
 * 
 * 2) A second field will keep the name of the actual name of sport.
 * 
 * 3) A third field, of type Place, will allow to define if the sport is
 * practiced indoor or outdoor
 * 
 * @author Matteo Casadei
 *
 */
public enum Sport {

    BASKET(Place.INDOOR, 5, "Basketball"), 
    VOLLEY(Place.INDOOR, 6, "Volleyball"), 
    TENNIS(Place.OUTDOOR, 1, "Tennis"), 
    BIKE(Place.OUTDOOR, 1, "Road biking"), 
    F1(Place.OUTDOOR, 1, "Formula 1"), 
    MOTOGP(Place.OUTDOOR, 1, "MotoGP"), 
    SOCCER(Place.OUTDOOR, 11, "Football");

    private final Place place;
    private final Integer noTeamMembers;
    private final String actualName;

    Sport(final Place pl, final int teamMembers, final String realName) {
        this.place = pl;
        this.noTeamMembers = teamMembers;
        this.actualName = realName;
    }

    /**
     * Must return true only if called on individual sports.
     * 
     * @return true if the sport is an individual one, false otherwise
     */
    public boolean isIndividualSport() {
        return this.noTeamMembers == 1;
    }

    /**
     * Must return true in case the sport is practices indoor.
     * 
     * @return true if this sport is practices indoor, false in any other case
     */
    public boolean isIndoorSport() {
        return this.place.equals(Place.INDOOR);
    }

    /**
     * Must return the place where this sport is practiced.
     * 
     * @return the place where the sport is played
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Returns the usual string representation of a sport.
     * 
     * @return the text representation of the sport
     */
    public String toString() {
        return "Sport[ name=" + this.actualName + ", place=" + this.place
                + ", peoplePerTeam=" + this.noTeamMembers + "]";
    }
}
