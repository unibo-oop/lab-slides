package it.unibo.oop.lab07.exercise01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;

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
        try {
            for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
                r1.moveRight();
            }

            // this is causing an exception to be raised
            r1.moveRight();
            // this must not be reached;
            fail("I should not get such far!");
        } catch (PositionOutOfBoundException e) {
            assertThat(e.getMessage(), containsString("pos(" + (RobotEnvironment.WORLD_X_UPPER_LIMIT + 1) + ", 0)"));
        } catch (NotEnoughBatteryException e) {
            fail("No battery problems expected here!");
        }
        /*
         * 2) Provare a muovere SimpleRobot verso il basso, fino a giungere
         * all'angolo in alto a destra del RobotEnvironment controllando che il
         * metodo restituisca false quando si superano i limiti del mondo
         */
        try {
            for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
                // check if position if coherent
                r1.moveUp();
            }
            r1.moveUp();
        } catch (PositionOutOfBoundException e) {
            assertThat(e.getMessage(), containsString("pos(" + RobotEnvironment.WORLD_X_UPPER_LIMIT + ", "
                    + (RobotEnvironment.WORLD_Y_UPPER_LIMIT + 1) + ")"));
        } catch (NotEnoughBatteryException e) {
            fail("Battery should not be the issue here!");
        }

    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        // 1) Creare il robot SimpleRobot2, istanza della classe Robot con
        // batteria=20
        Robot r2 = new Robot("SimpleRobot2", 20);

        /*
         * 2) Muovere ripetutamente il robot su di una posizione e giù di una
         * posizione fino a scaricare completamente la batteria e gestendo
         * opportunamente l'eccezione che viene lanciata (costrutto try-catch).
         * Utilizzare inoltre il blocco finally per ricaricare la batteria del
         * robot dopo che è stata consumata completamente.
         */
        try {
            while (r2.getBatteryLevel() > 0) {
                r2.moveUp();
                r2.moveDown();
            }
            r2.moveDown();
            fail("You not supposed to get that far with no battery!");
        } catch (PositionOutOfBoundException e) {
            fail("I expect battery to fail!");
        } catch (NotEnoughBatteryException e) {
            assertThat(e.getMessage(), containsString(" Battery level is " + r2.getBatteryLevel()));
        }
    }
}