package it.unibo.oop.lab07.exercise04;

/**
 * Models a generic robot part.
 * 
 */
public interface RobotPart {

    /**
     * Turn on the robot part.
     * 
     * @return true if this part has been turned on
     * @throws CantTurnOnException
     *             if the part is already turned on
     */
    boolean turnOn() throws CantTurnOnException;

    /**
     * Turn off the robot part.
     * 
     * @return true if this part has been turned off
     * @throws CantTurnOffException
     *             if the part is already turned off
     */
    boolean turnOff() throws CantTurnOffException;

    /**
     * Return true if the part is on.
     * 
     * @return The true if the robot part is on
     */
    boolean isOn();

    /**
     * Return the description of the part.
     * 
     * @return the description of the robot part
     */
    String getDescription();
}