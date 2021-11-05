package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.base.RobotEnvironment;
import it.unibo.oop.lab04.robot.base.RobotPosition;
import static it.unibo.oop.lab04.Assertions.assertEquals;

/**
 * Utility class for testing componible robots
 */
public final class TestRobots {

    private TestRobots() {
    }

    public static void main(final String[] args) {
        final var stepsDefault = (int) (BaseRobot.BATTERY_FULL / BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
        final var r0 = new BaseRobot("R2D2");
        final var r0pos = r0 + " position";
        final var r0bat = r0 + " battery";
        assertEquals(r0pos, new RobotPosition(0, 0), r0.getPosition());
        assertEquals(r0bat, BaseRobot.BATTERY_FULL, r0.getBatteryLevel());
        var steps = stepsDefault;
        while (r0.moveUp()) {
            steps--;
        }
        if (steps == 0) {
            assertEquals(r0bat, true, r0.getBatteryLevel() < BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
            r0.recharge();
            assertEquals(r0bat, BaseRobot.BATTERY_FULL, r0.getBatteryLevel());
            steps = stepsDefault;
        } else {
            assertEquals(r0pos, new RobotPosition(0, RobotEnvironment.Y_UPPER_LIMIT), r0.getPosition());
        }
        while (r0.moveRight()) {
            steps--;
        }
        if (steps == 0) {
            assertEquals(r0bat, true, r0.getBatteryLevel() < BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
            r0.recharge();
            assertEquals(r0bat, BaseRobot.BATTERY_FULL, r0.getBatteryLevel());
            steps = stepsDefault;
        } else {
            assertEquals(r0pos,
                new RobotPosition(RobotEnvironment.X_UPPER_LIMIT, RobotEnvironment.Y_UPPER_LIMIT),
                r0.getPosition());
        }
        while (r0.moveRight()) {
            steps--;
        }
        if (steps == 0) {
            assertEquals(r0bat, true, r0.getBatteryLevel() < BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
            r0.recharge();
            assertEquals(r0bat, BaseRobot.BATTERY_FULL, r0.getBatteryLevel());
            steps = stepsDefault;
        } else {
            assertEquals(r0pos,
                new RobotPosition(RobotEnvironment.X_UPPER_LIMIT, RobotEnvironment.Y_UPPER_LIMIT),
                r0.getPosition());
        }

    }
}
