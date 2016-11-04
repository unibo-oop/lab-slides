package it.unibo.oop.lab.reflection02;

/**
 * Models a generic robot part.
 * 
 */
public interface RobotPart {

    /**
     * Turn on the robot part.
     * 
     * @return true if this part has been turned on
     * 
     */
    boolean turnOn();

    /**
     * Turn off the robot part.
     * 
     * @return true if this part has been turned off
     * 
     */
    boolean turnOff();

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