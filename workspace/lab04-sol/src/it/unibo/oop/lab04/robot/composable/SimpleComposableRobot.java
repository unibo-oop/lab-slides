package it.unibo.oop.lab04.robot.composable;

import java.util.Arrays;
import java.util.Objects;

import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.components.RobotPart;

/**
 * @author Danilo Pianini
 *
 */
public class SimpleComposableRobot extends BaseRobot implements ComposableRobot {

    private RobotPart[] parts = new RobotPart[0];

    public SimpleComposableRobot(final String robotName) {
        super(robotName);
    }

    public final void attachComponent(final RobotPart rp) {
        Objects.requireNonNull(rp);
        rp.plug(this);
        if (rp.isPluggedTo(this)) {
            parts = Arrays.copyOf(parts, parts.length + 1);
            parts[parts.length - 1] = rp;
        }
    }

    public final void doCycle() {
        for (final RobotPart p : parts) {
            if (p.isOn()) {
                if (p.isPluggedTo(this)) {
                    if (p.getEnergyRequired() < getBatteryLevel() && p.doOperation()) {
                        consumeBattery(p.getEnergyRequired());
                        log(p + " operated successfully.");
                    } else {
                        log(p + " did not work properly.");
                    }
                } else {
                    log(p + " is not connected.");
                }
            } else {
                log(p + " is off.");
            }
        }
    }

    public final void detachComponent(final RobotPart rp) {
        Objects.requireNonNull(rp);
        final int index = indexOf(rp);
        if (index >= 0) {
            final RobotPart[] na = new RobotPart[parts.length - 1];
            for (int i = 0; i < index; i++) {
                na[i] = parts[i];
            }
            for (int i = index + 1; i < parts.length; i++) {
                na[i - 1] = parts[i];
            }
            parts = na;
        }
    }

    private int indexOf(final RobotPart rp) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(rp)) {
                return i;
            }
        }
        return -1;
    }

}
