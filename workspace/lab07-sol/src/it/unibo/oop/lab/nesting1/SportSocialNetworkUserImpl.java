/**
 * 
 */
package it.unibo.oop.lab.nesting1;

import java.util.HashSet;
import java.util.Set;

import it.unibo.oop.lab.socialnetwork.SocialNetworkUserImpl;
import it.unibo.oop.lab.socialnetwork.User;

/**
 * 
 * Represents a social network user along with the sports he/she likes to do or
 * to follow
 * 
 * The sport has to be defined as a nested static class, featuring just a field
 * representing the sport name.
 * 
 * @param <U>
 *            specific {@link User} type
 */
public class SportSocialNetworkUserImpl<U extends User> extends SocialNetworkUserImpl<U> {
 
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport SOCCER = new Sport("Football");
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport F1 = new Sport("Formula 1");
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport MOTOGP = new Sport("MotoGP");
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport VOLLEY = new Sport("Volleyball");
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport BASKET = new Sport("Basketball");
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport BIKE = new Sport("Road biking");

    /**
     * Field meant to keep track of the set of sports followed/done by a user
     */
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
    public SportSocialNetworkUserImpl(final String name, final String surname, final String user) {
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
    public SportSocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
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
     * @return true if a user likes sport s
     */
    public boolean hasSport(final Sport s) {
        return this.sports.contains(s);
    }

    /**
     * Implements a static inner class defining a Sport along with its bare
     * name.
     */
    public static class Sport {
        private final String n;
        private int hash;

        /**
         * @param name
         *            the sport name
         */
        public Sport(final String name) {
            this.n = name;
        }

        /*
         * Redefine equals so that two sports are equal only if they feature the
         * very same name.
         */
        /**
         * {@inheritDoc}
         */
        public boolean equals(final Object o) {
            if (o == null) {
                return false;
            }
            if (getClass().equals(o.getClass())) {
                return n.equals(((Sport) o).n);
            }
            return false;
        }

        /*
         * Also hashCode must be re-implemented, or this class would violate the
         * equals/hashCode contract.
         */
        /**
         * {@inheritDoc}
         */
        public int hashCode() {
            /*
             * All fields are final. Moreover, there is equality with String. As
             * such, hashCode() must mimic String hashCode, and lazy init is
             * doable.
             */
            if (hash == 0) {
                hash = n.hashCode();
            }
            return hash;
        }
    }
}
