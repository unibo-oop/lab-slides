package it.unibo.oop.lab06.exercise2;

import it.unibo.oop.lab06.exercise1.User;

/**
 * This is going to act as a test for
 * {@link it.unibo.oop.lab06.exercise2.SportSocialNetworkUserImpl}
 * 
 * 1) Complete the test as per comments below
 * 
 * 2) Run it: every test must return true.
 * 
 * @author Matteo Casadei
 * @author Danilo Pianini
 *
 */
public final class TestSportByStaticInnerClass {

    private TestSportByStaticInnerClass() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {

        /*
         * create 3 sport social network users (SportSocialNetworkUser):
         * 
         * Davide Cassani , dcassani, 53
         * 
         * Bernie Ecclestone, decclestone, 83
         * 
         * Fernando Alonso, falonso, 34
         */
        final SportSocialNetworkUserImpl<User> dcassani = new SportSocialNetworkUserImpl<>(
                "Davide", "Cassani", "dcassani", 53);
        final SportSocialNetworkUserImpl<User> becclestone = new SportSocialNetworkUserImpl<>(
                "Bernie", "Ecclestone", "becclestone", 83);
        final SportSocialNetworkUserImpl<User> falonso = new SportSocialNetworkUserImpl<>(
                "Fernando", "Alonso", "falonso", 34);

        /*
         * alonso in a fan of soccer and bike and practices F1: add these sports
         * to Alonso
         * 
         * falonso.addSport(SportSocialNetworkUserImpl.F1);
         * 
         * ...
         */
        System.out.println("Alonso practices F1: "
                + falonso.hasSport(SportSocialNetworkUserImpl.F1));
        System.out.println("Alonso does not lime volley: "
                + !falonso.hasSport(SportSocialNetworkUserImpl.VOLLEY));

        /*
         * Cassani practiced bike and loves F1 and MotoGP: add these sports to
         * Cassani
         */
        dcassani.addSport(SportSocialNetworkUserImpl.BIKE);
        dcassani.addSport(SportSocialNetworkUserImpl.F1);
        dcassani.addSport(SportSocialNetworkUserImpl.MOTOGP);

        System.out.println("Cassani has been a professional biker: "
                + dcassani.hasSport(SportSocialNetworkUserImpl.BIKE));
        System.out.println("Cassani does not like soccer: "
                + !dcassani.hasSport(SportSocialNetworkUserImpl.SOCCER));

        /**
         * Ecclestone is the defacto owner of F1 but also is fan of basket: add
         * these sports to hime
         */
        becclestone.addSport(SportSocialNetworkUserImpl.F1);
        becclestone.addSport(SportSocialNetworkUserImpl.BASKET);

        System.out.println("Bernie's the boss when it comes to F1: "
                + becclestone.hasSport(SportSocialNetworkUserImpl.F1));
        System.out.println("Bernie does love playing also basket: "
                + becclestone.hasSport(SportSocialNetworkUserImpl.BASKET));
    }

}
