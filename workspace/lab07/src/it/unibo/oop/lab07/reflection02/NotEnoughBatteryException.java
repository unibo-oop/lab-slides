package it.unibo.oop.lab07.reflection02;

/**
 * 
 * Model an exception occurring if the battery level is not enough to perform an
 * action on the robot.
 * 
 */
@SuppressWarnings("serial")
public class NotEnoughBatteryException extends RobotException {

    private final double batteryLevel;
    private final double batteyRequired;

    /**
     * 
     * @param batteryLevel
     *            current battery level
     * @param batteryRequired
     *            required level to complete action
     */
    public NotEnoughBatteryException(final double batteryLevel, final double batteryRequired) {
        this.batteryLevel = batteryLevel;
        this.batteyRequired = batteryRequired;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String toString() {
        return "No enough battery for moving. Battery level is " + batteryLevel + " battery required is "
                + batteyRequired;
    }
}