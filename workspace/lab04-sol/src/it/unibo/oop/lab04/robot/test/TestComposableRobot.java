package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.components.AtomicBattery;
import it.unibo.oop.lab04.robot.components.BorderNavigator;
import it.unibo.oop.lab04.robot.components.CommandableRobotPart;
import it.unibo.oop.lab04.robot.components.RobotPart;
import it.unibo.oop.lab04.robot.components.RobotArm;
import it.unibo.oop.lab04.robot.composable.SimpleComposableRobot;
import it.unibo.oop.lab04.robot.composable.ComposableRobot;

/**
 * Utility class for testing composable robots
 * 
 * @author Danilo Pianini
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() { }

    public static void main(final String[] args) {

        final ComposableRobot r0 = new SimpleComposableRobot("Evangelion Unit 01");
        final RobotPart navi = new BorderNavigator();
        final RobotPart battery = new AtomicBattery();
        final CommandableRobotPart arm1 = new RobotArm();
        final CommandableRobotPart arm2 = new RobotArm();

        r0.attachComponent(navi);
        r0.attachComponent(battery);
        r0.attachComponent(arm1);
        r0.attachComponent(arm2);

        navi.turnOn();
        arm1.turnOn();
        arm2.turnOn();

        for (int i = 0; i < CYCLES; i++) {
            if (r0.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
                battery.turnOff();
            }
            arm1.sendCommand(arm1.availableCommands()[i % arm1.availableCommands().length]);
            arm2.sendCommand(arm2.availableCommands()[i % arm2.availableCommands().length]);
            r0.doCycle();
        }
        
        r0.detachComponent(arm1);
        r0.detachComponent(arm2);
        r0.doCycle();
        r0.doCycle();
    }
}