package it.unibo.oop.lab07.exercise04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Act as a convenience JUnit test of a robot factory.
 * 
 * @author Matteo Casadei
 *
 */
public class TestFactory {

    /**
     * Test a Robot Factory.
     */
    @Test
    public void testRobotFactory() {
        try {
            final ComposableRobot r1 = ComposableRobotFactory.createBasicComposableRobot(BasicComposableRobots.WITH_HEAD,
                    "Rob1 (Robot with head)", 100);
            final ComposableRobot r2 = ComposableRobotFactory.createBasicComposableRobot(BasicComposableRobots.WITH_TWO_ARMS,
                    "Rob2 (Robot with two arms)", 100);
            final ComposableRobot r3 = ComposableRobotFactory.createBasicComposableRobot(
                    BasicComposableRobots.WITH_TWO_ARMS_AND_HEAD, "Rob3 (Robot with two arms and one head)", 100);
            assertEquals("r1 wrong", r1.getParts().length, 1);
            assertEquals("r2 wrong", r2.getParts().length, 2);
            assertEquals("r3 wrong", r3.getParts().length, 3);
            // other consistency checks can be written

        } catch (RobotException ex) {
            System.out.println("Something wrong happened!");
        }
    }
}