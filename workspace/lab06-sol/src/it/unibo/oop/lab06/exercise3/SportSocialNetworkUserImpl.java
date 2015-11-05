/**
 * 
 */
package it.unibo.oop.lab06.exercise3;

import java.util.HashSet;
import java.util.Set;

import it.unibo.oop.lab06.exercise1.User;
import it.unibo.oop.lab06.exercise1.SocialNetworkUserImpl;

/**
 * 
 * Represents a social network user along with the sports he/she likes to do or
 * to follow.
 * 
 * 1) Define the same behavior as done on the previous exercise: - you can reuse
 * the same class, but... - ..now make explicit reference to an enumeration
 * Sport rather than a nested static class
 * 
 * 
 * - NOTE: now we going to define Sport as an enumeration (in its own file
 * Sport.java)
 * 
 * 
 * @author Matteo Casadei
 * @author Danilo Pianini
 *
 * @param <U>
 *            specific user type
 */
public class SportSocialNetworkUserImpl<U extends User> extends
        SocialNetworkUserImpl<U> {

    private final Set<Sport> sports;

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SportSocialNetworkUserImpl(final String name, final String surname,
            final String user) {
        this(name, surname, user, -1);
    }

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SportSocialNetworkUserImpl(final String name, final String surname,
            final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.sports = new HashSet<>();
    }

    /**
     * Add a new sport followed by this user: if the user already likes or does
     * the sport, nothing happens.
     * 
     * @param sport
     *            a sport followed/done by the user
     */
    public void addSport(final Sport sport) {
        this.sports.add(sport);
    }

    /**
     * Returns true if a user likes/does a given sport.
     * 
     * @param s
     *            sport to use as an input
     * 
     * @return true if the user likes sport s
     */
    public boolean hasSport(final Sport s) {
        return this.sports.contains(s);
    }
}
