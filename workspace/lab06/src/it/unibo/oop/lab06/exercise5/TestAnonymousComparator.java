/**
 * 
 */
package it.unibo.oop.lab06.exercise5;

import it.unibo.oop.lab06.exercise1.SocialNetworkUser;
import it.unibo.oop.lab06.exercise1.SocialNetworkUserImpl;
import it.unibo.oop.lab06.exercise1.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Instruction: define two comparators as anonymous classes in oder to sort a
 * list of user in the appropriate way.
 * 
 * 1) Study carefully the test in order to understand it 2) Introduce the
 * anonymous comparator where required in order to make the test succeed.
 * 
 * (Refer to: 12-Advanced-Mechanisms.pdf, slide 39)
 * 
 * @author Matteo Casadei
 * @author Danilo Pianini
 *
 */
public final class TestAnonymousComparator {

    private TestAnonymousComparator() {

    }

    /**
     * Check whether the users in result list are in the same order as those in
     * expected.
     * 
     * @param expected
     *            the expected list of users
     * @param result
     *            the list of users returned by the test
     * @return true is result's users are in the same order as expected's users
     */
    public static boolean checkUserOrder(final List<User> expected, final List<User> result) {
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(result.get(i))) {
                System.out.println("    [EXCEPTION] [POS. " + i + "] [EXPECTED] " + expected.get(i) + " [GOT] "
                        + result.get(i));
                return false;
            }
        }
        return true;
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {

        /*
         * create 6 social network users
         */
        final SocialNetworkUser<User> kbacon = new SocialNetworkUserImpl<>("Kevin", "Bacon", "kbacon", 56);
        final SocialNetworkUser<User> dwashington = new SocialNetworkUserImpl<>("Denzel", "Washington", "dwashington", 59);
        final SocialNetworkUser<User> mgladwell = new SocialNetworkUserImpl<>("Malcom", "Gladwell", "mgladwell", 51);
        final SocialNetworkUser<User> ntaleb = new SocialNetworkUserImpl<>("Nicholas", "Taleb", "ntaleb", 54);
        final SocialNetworkUser<User> mrossi = new SocialNetworkUserImpl<>("Mario", "Rossi", "mrossi", 31);
        final SocialNetworkUser<User> pverdi = new SocialNetworkUserImpl<>("Paolo", "Verdi", "pverdi", 24);

        // TEST on DENZEL
        dwashington.addFollowedUser("relatives", mrossi);
        dwashington.addFollowedUser("relatives", pverdi);
        dwashington.addFollowedUser("colleagues", kbacon);
        dwashington.addFollowedUser("writers", mgladwell);
        dwashington.addFollowedUser("writers", ntaleb);
        final List<User> denzelUsers = dwashington.getFollowedUsers();

        /*
         * Order denzel's followed users incrementally by age:
         * 
         * - define an anonymous comparator to sort incrementally by age
         * 
         * NOTE: in order to sort a list think about a method of the utility
         * class java.util.Collections
         * 
         * REFER TO LESSON 12-Advanced-Mechanisms.pdf, slide 39
         */
        // TODO

        /*
         * expected Result
         */
        List<User> expectedResult = new ArrayList<User>();
        expectedResult.add(pverdi);
        expectedResult.add(mrossi);
        expectedResult.add(mgladwell);
        expectedResult.add(ntaleb);
        expectedResult.add(kbacon);

        System.out.println("[Order by age (increasing) Denzel friends] [TEST] [START]");
        System.out.println("[Order by age (increasing) Denzel friends] [TEST] [RESULT] "
                + checkUserOrder(expectedResult, denzelUsers));
        System.out.println("[Order by age (increasing) Denzel friends] [TEST] [END]");

        // TEST on MARIO ROSSI
        mrossi.addFollowedUser("relatives", pverdi);
        mrossi.addFollowedUser("actors i like", kbacon);
        mrossi.addFollowedUser("science writers", mgladwell);
        mrossi.addFollowedUser("economists", ntaleb);
        mrossi.addFollowedUser("actors i like", dwashington);
        final List<User> rossiUsers = mrossi.getFollowedUsers();

        /*
         * Order rossi's followed users by age in decreasing order:
         * 
         * - define an anonymous comparator to sort by age decrementally
         * 
         * NOTE: in order to sort a list think about a method of the utility
         * class Collections
         * 
         * REFER TO LESSON 12-Advanced-Mechanisms.pdf, slide 39
         */
        // TODO

        /*
         * expected Result
         */
        expectedResult = new ArrayList<User>();
        expectedResult.add(dwashington);
        expectedResult.add(kbacon);
        expectedResult.add(ntaleb);
        expectedResult.add(mgladwell);
        expectedResult.add(pverdi);

        System.out.println("[Order by age (decreasing) Rossi friends] [TEST] [START]");
        System.out.println("[Order by age (decreasing) Rossi friends] [TEST] [RESULT] "
                + checkUserOrder(expectedResult, rossiUsers));
        System.out.println("[Order by age (decreasing) Rossi friends] [TEST] [END]");

    }

}
