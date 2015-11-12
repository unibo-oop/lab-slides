package it.unibo.oop.lab07.exercise01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Testing class for PositionOutOfBound.
 * 
 * @author Matteo Casadei
 *
 */
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
    @Test
    public void testRobotMovementBase() {
        // 1) Creare il robot SimpleRobot, istanza della classe Robot con
        // batteria=100
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot in in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());

        /*
         * 2) Provare a muovere SimpleRobot verso dx, fino a giungere all'angolo
         * in basso a destra del RobotEnvironment controllando che il metodo
         * restituisca false quando si superano i limiti del mondo
         */
        for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
            // check if position if coherent
            assertTrue("[CHECKING MOVING RIGHT]", r1.moveRight());
        }
        // reached the right limit of the world
        assertFalse("[CHECKING MOVING RIGHT]", r1.moveRight());
        // checking positions x=50; y=0
        assertEquals("[MOVING RIGHT ROBOT POS X]", 50, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", 0, r1.getEnvironment().getCurrPosY());

        /*
         * 2) Provare a muovere SimpleRobot verso il basso, fino a giungere
         * all'angolo in alto a destra del RobotEnvironment controllando che il
         * metodo restituisca false quando si superano i limiti del mondo
         */
        for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
            // check if position if coherent
            assertTrue("[CHECKING MOVING UP]", r1.moveUp());
        }
        // reached the upper limit of the world
        assertFalse("[CHECKING MOVING UP]", r1.moveUp());
        // checking positions x=50; y=80
        assertEquals("[MOVING RIGHT ROBOT POS X]", 50, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", 80, r1.getEnvironment().getCurrPosY());

    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        // 1) Creare il robot SimpleRobot2, istanza della classe Robot con
        // batteria=20
        final Robot r2 = new Robot("SimpleRobot2", 20);

        /*
         * 2) Muovere ripetutamente il robot su di una posizione e giù di una
         * posizione fino a scaricare completamente la batteria e gestendo
         * opportunamente l'eccezione che viene lanciata (costrutto try-catch).
         * Utilizzare inoltre il blocco finally per ricaricare la batteria del
         * robot dopo che è stata consumata completamente.
         */

        while (r2.getBatteryLevel() > 0) {
            r2.moveUp();
            r2.moveDown();
        }
        // verify battery level:
        // expected, actual, delta (accepted error as we deal with decimal
        // values: in this case we accept NO ERROR)
        assertEquals(0d, r2.getBatteryLevel(), 0);
        // verify position: same as start position
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r2.getEnvironment().getCurrPosY());
        // out of world: returns false
        assertFalse("[CHECKING MOVING UP]", r2.moveUp());

        // recharging battery
        r2.recharge();
        // verify battery level
        assertEquals(100, r2.getBatteryLevel(), 0);
    }
}