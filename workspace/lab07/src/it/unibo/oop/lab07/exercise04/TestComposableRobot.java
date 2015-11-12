package it.unibo.oop.lab07.exercise04;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Act as a convenience JUnit test of a robot factory.
 * 
 * @author Matteo Casadei
 *
 */
public class TestComposableRobot {

    /**
     * Test a Robot Factory.
     */
    /*
    @Test
    public void testParts() {
        RobotArm left = new RobotArm("Left arm");
        RobotArm right = new RobotArm("Right arm");
        RobotHead head = new RobotHead("head");
        
        //turning parts on
        try {
            left.turnOn();
            right.turnOn();
            head.turnOn();
        } catch (CantTurnOnException e) {
            assertTrue("Test failed: parts must be activated with no issues", false);
        }
        try {
            left.turnOn();
            assertTrue("Left arm cannot be activated againg", false);
        } catch (CantTurnOnException e) {
            assertTrue(true);
        }
        try {
            right.turnOff();
            head.turnOff();
        } catch (CantTurnOffException e) {
            assertTrue("Test failed: parts must be deactivated with no issues", false);
        }
        try {
            right.turnOff();
            assertTrue("Test failed: right arm already off", false);
        } catch (CantTurnOffException e) {
            assertTrue(true);
        }
     }*/
        
}