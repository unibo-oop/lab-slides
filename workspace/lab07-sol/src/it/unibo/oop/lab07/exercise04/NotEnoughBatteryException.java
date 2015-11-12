package it.unibo.oop.lab07.exercise04;

/**
 * 
 * Model an exception occurring if the battery level is not enough to perform an
 * action on the robot.
 * 
 * @author Matteo Casadei
 *
 */
public class NotEnoughBatteryException extends RobotException {

    /**
     * 
     */
    private static final long serialVersionUID = -2084397338001404484L;
    private final double batteryLevel;
    private final double batteyRequired;

    /**
     * 
     * @param batteryLevel
     *            current battery level
     * @param required
     *            required level to complete action
     */
    public NotEnoughBatteryException(final double batteryLevel, final double required) {
        super();
        this.batteryLevel = batteryLevel;
        this.batteyRequired = required;
    }

    @Override
    public String toString() {
        return "No enough battery for moving. Battery level is " + batteryLevel + " battery required is " + batteyRequired;
    }
}