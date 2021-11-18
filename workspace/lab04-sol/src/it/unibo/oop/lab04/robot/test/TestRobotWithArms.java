package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.arms.RobotWithArms;
import it.unibo.oop.lab04.robot.arms.RobotWithTwoArms;
import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.base.RobotPosition;
import static it.unibo.oop.lab04.Assertions.assertEquals;

/**
 * Utility class for testing componible robots
 * 
 */
public final class TestRobotWithArms {

    // Tolerance for double comparisons, to account for floating-point rounding errors  
    private static final double EPSILON = 1e-7;

    private static final int CYCLES = 10;

    private TestRobotWithArms() {
    }

    public static void main(final String[] args) {
        final RobotWithArms walle = new RobotWithTwoArms("Wall-e");
        final String wallePosition = walle + "'s position";
        final String walleItems = walle + "'s items carried";
        final String walleConsumption = walle + "'s consumption is correct";
        assertEquals(wallePosition, new RobotPosition(0, 0), walle.getPosition());
        assertEquals(walleConsumption, BaseRobot.BATTERY_FULL, walle.getBatteryLevel(), EPSILON);
        double consumptionEmpty = walle.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            walle.moveRight();
        }
        consumptionEmpty -= walle.getBatteryLevel();
        walle.pickUp();
        assertEquals(walleItems, 1, walle.getCarriedItemsCount());
        double consumption1Item = walle.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            walle.moveUp();
        }
        consumption1Item -= walle.getBatteryLevel();
        assertEquals(walleConsumption, true, consumption1Item > consumptionEmpty);
        walle.pickUp();
        assertEquals(walleItems, 2, walle.getCarriedItemsCount());
        double consumption2Item = walle.getBatteryLevel();
        for (int i = 0; i < CYCLES; i++) {
            walle.moveUp();
        }
        consumption2Item -= walle.getBatteryLevel();
        assertEquals(walleConsumption, true, consumption2Item > consumption1Item);
        walle.pickUp();
        assertEquals(walleItems, 2, walle.getCarriedItemsCount());
        walle.dropDown();
        assertEquals(walleItems, 1, walle.getCarriedItemsCount());
        walle.dropDown();
        assertEquals(walleItems, 0, walle.getCarriedItemsCount());
        walle.dropDown();
        assertEquals(walleItems, 0, walle.getCarriedItemsCount());
    }
}
