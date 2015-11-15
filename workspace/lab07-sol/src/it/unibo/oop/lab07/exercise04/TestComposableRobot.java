package it.unibo.oop.lab07.exercise04;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Act as a convenience JUnit test of a robot factory.
 *
 */
public class TestComposableRobot {

    /**
     * Test a Robot Factory.
     */
    @Test
    public void testParts() {
        final RobotArm left = new RobotArm("Left arm");
        final RobotArm right = new RobotArm("Right arm");
        final RobotHead head = new RobotHead("head");

        // turning parts on
        try {
            left.turnOn();
            right.turnOn();
            head.turnOn();
        } catch (CantTurnOnException e) {
            fail();
        }
        try {
            left.turnOn();
            fail();
        } catch (CantTurnOnException e) {
            assertNotNull(e);
        }
        try {
            right.turnOff();
            head.turnOff();
        } catch (CantTurnOffException e) {
            fail();
        }
        try {
            right.turnOff();
            fail();
        } catch (CantTurnOffException e) {
            assertNotNull(e);
        }
    }

}