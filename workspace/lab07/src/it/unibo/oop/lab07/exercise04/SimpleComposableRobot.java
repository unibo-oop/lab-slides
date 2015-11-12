package it.unibo.oop.lab07.exercise04;

import java.util.Arrays;

/**
 * Concrete implementation of a robot composed by a set of generic
 * {@link RobotPart}.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public class SimpleComposableRobot extends Robot implements ComposableRobot {

    private final RobotPart[] parts;
    private static final double MOVEMENT_DELTA_CONSUMPTION_FOR_PART = 0.1;

    /**
     * 
     * @param robotName
     *            name of the robot at hand
     * @param parts
     *            array of parts the robot is composed of
     * @param batteryLevel
     *            initial level of the battery
     */
    public SimpleComposableRobot(final String robotName, final RobotPart[] parts, final double batteryLevel) {
        super(robotName, batteryLevel);
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    /**
     * @return the array of the robot composing parts.
     */
    public RobotPart[] getParts() {
        return Arrays.copyOf(this.parts, this.parts.length);
    }

    /**
     * Invoke the {@link AbstractMovementPart#doMove} method for all the
     * {@link AbstractMovementPart} available.
     * 
     * @throws NotEnoughBatteryException
     *             if the battery if not enough to complete the movement of the
     *             active parts
     */
    public void workWithMovementParts() throws NotEnoughBatteryException {
        for (final RobotPart part : this.parts) {
            if (part instanceof AbstractMovementPart && part.isOn()) {
                final AbstractMovementPart movingPart = (AbstractMovementPart) part;
                if (this.getBatteryLevel() >= movingPart.getEnergyRequiredForMoving()) {
                    this.log("Moving part " + movingPart.getDescription());
                    this.consumeBattery(movingPart.getEnergyRequiredForMoving());
                } else {
                    throw new NotEnoughBatteryException(getBatteryLevel(), movingPart.getEnergyRequiredForMoving());
                }
            }
        }
    }

    /**
     * Log the status of all the robot parts.
     */
    public void logPartStatus() {
        for (final RobotPart part : this.parts) {
            this.log("Current status for part " + part.getDescription() + " is: " + part.isOn());
        }
    }

    /**
     * Turn on all the {@link RobotPart} invoking the method
     * {@link RobotPart#turnOn} for each one of them.
     */
    public void turnOnAll() {
        for (final RobotPart part : this.parts) {
            this.log("Turning on part " + part.getDescription());
            if (!part.turnOn()) {
                this.log("Can not turn on " + part + ". Is alredy on");
            }
        }
    }

    /**
     * Turn off all the {@link RobotPart} invoking the method
     * {@link RobotPart#turnOff} for each one of them.
     */
    public void turnOffAll() {
        for (final RobotPart part : this.parts) {
            this.log("Turning off part " + part.getDescription());
            if (!part.turnOff()) {
                this.log("Can not turn off " + part + ". Is alredy off");
            }
        }
    }

    /**
     * Consume the energy required for moving from the battery, taking into the
     * account an energy contribution for each {@link RobotPart}.
     */
    protected void consumeBatteryForMovement() {
        super.consumeBatteryForMovement();
        this.consumeBattery(this.parts.length * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
    }
}