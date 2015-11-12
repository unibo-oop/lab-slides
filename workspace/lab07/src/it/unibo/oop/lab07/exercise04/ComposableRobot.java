package it.unibo.oop.lab07.exercise04;

/**
 * Concrete implementation of a robot composed by a set of generic
 * {@link it.unibo.oop.lab07.exercise04.IRobotPart}.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public class ComposableRobot extends Robot implements IComposableRobot {

    private final IRobotPart[] parts;
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
    public ComposableRobot(final String robotName, final IRobotPart parts[],
            final double batteryLevel) {
        super(robotName, batteryLevel);
        this.parts = parts;
    }

    /**
     * @return the array of the robot composing parts.
     */
    public IRobotPart[] getParts() {
        return this.parts;
    }

    /**
     * Invoke the {@link it.unibo.oop.lab07.AbstractMovementPart#doMove()}
     * method for all the {@link it.unibo.oop.lab07.AbstractMovementPart}
     * available.
     * 
     * @throws NotEnoughBatteryException
     *             if the battery if not enough to complete the movement of the
     *             active parts
     */
    public void workWithMovementParts() throws NotEnoughBatteryException {
        for (IRobotPart part : this.parts) {
            if (part instanceof AbstractMovementPart && part.isOn()) {
                AbstractMovementPart movingPart = (AbstractMovementPart) part;
                if (this.getBatteryLevel() >= movingPart
                        .getEnergyRequiredForMoving()) {
                    this.log("Moving part " + movingPart.getDescription());
                    this.consumeBattery(movingPart.getEnergyRequiredForMoving());
                } else {
                    throw new NotEnoughBatteryException(getBatteryLevel(),
                            movingPart.getEnergyRequiredForMoving());
                }
            }
        }
    }

    /**
     * Log the status of all the robot parts.
     */
    public void logPartStatus() {
        for (IRobotPart part : this.parts) {
            this.log("Current status for part " + part.getDescription()
                    + " is: " + part.isOn());
        }
    }

    /**
     * Turn on all the {@link it.unibo.oop.lab07.IRobotPart} invoking the method
     * {@link it.unibo.oop.lab07.IRobotPart#turnOn()} for each one of them.
     */
    public void turnOnAll() {
        for (IRobotPart part : this.parts) {
            this.log("Turning on part " + part.getDescription());
            if (!part.turnOn()) {
                this.log("Can not turn on " + part + ". Is alredy on");
            }
        }
    }

    /**
     * Turn off all the {@link oit.unibo.oop.lab07.IRobotPart} invoking the
     * method {@link oit.unibo.oop.lab07.IRobotPart#turnOff()} for each one of
     * them.
     */
    public void turnOffAll() {
        for (IRobotPart part : this.parts) {
            this.log("Turning off part " + part.getDescription());
            if (!part.turnOff()) {
                this.log("Can not turn off " + part + ". Is alredy off");
            }
        }
    }

    /**
     * Consume the energy required for moving from the battery, taking into the
     * account an energy contribution for each
     * {@link it.unibo.oop.lab07.IRobotPart}.
     */
    protected void consumeBatteryForMovement() {
        super.consumeBatteryForMovement();
        this.consumeBattery(this.parts.length
                * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
    }
}