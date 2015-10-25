package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.arms.RobotWithArms;
import it.unibo.oop.lab04.robot.arms.RobotWithTwoArms;
import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.base.RobotPosition;

/**
 * Utility class for testing componible robots
 * 
 * @author Danilo Pianini
 */
public final class TestRobotWithArms {

    private static final int CYCLES = 10;

    private TestRobotWithArms() {
    }

    private static void assertEquality(final String propertyName, final Object expected, final Object actual) {
        if (actual == null || !actual.equals(expected)) {
            System.out.println(propertyName + " was expected to be " + expected + ", but it yields " + actual
                    + " (ERROR!)");
        } else {
            System.out.println(propertyName + ": " + actual + " (CORRECT)");
        }
    }

    public static void main(final String[] args) {

        final RobotWithArms r0 = new RobotWithTwoArms("Wall-e");
        final String r0pos = r0 + "'s position";
        final String r0arm = r0 + "'s items carried";
        final String r0bat = r0 + "'s consumption is correct";

        assertEquality(r0pos, new RobotPosition(0, 0), r0.getPosition());
        assertEquality(r0bat, BaseRobot.BATTERY_FULL, r0.getBatteryLevel());

        double consumptionEmpty = r0.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            r0.moveRight();
        }
        consumptionEmpty -= r0.getBatteryLevel();

        r0.pickUp();
        assertEquality(r0arm, 1, r0.getItemsCarried());

        double consumption1Item = r0.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            r0.moveUp();
        }
        consumption1Item -= r0.getBatteryLevel();
        assertEquality(r0bat, true, consumption1Item > consumptionEmpty);

        r0.pickUp();
        assertEquality(r0arm, 2, r0.getItemsCarried());

        double consumption2Item = r0.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            r0.moveUp();
        }
        consumption2Item -= r0.getBatteryLevel();
        assertEquality(r0bat, true, consumption2Item > consumption1Item);

        r0.pickUp();
        assertEquality(r0arm, 2, r0.getItemsCarried());
        r0.dropDown();
        assertEquality(r0arm, 1, r0.getItemsCarried());
        r0.dropDown();
        assertEquality(r0arm, 0, r0.getItemsCarried());
        r0.dropDown();
        assertEquality(r0arm, 0, r0.getItemsCarried());

    }
}