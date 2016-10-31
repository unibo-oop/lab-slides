package it.unibo.oop.lab07.reflection02;

/**
 * Models a robotic arm.
 * 
 */
public class RobotArm extends AbstractMovementPart {

    private boolean grabbing;
    private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;

    /**
     * 
     * @param description
     *            description of the robotic arm
     */
    public RobotArm(final String description) {
        super(RobotArm.ENERGY_REQUIRED_TO_MOVE, description);
    }

    /**
     * 
     * @return true if the movement has been done
     */
    public boolean doMove() {
        if (this.isOn() && !this.isGrabbing()) {
            this.grabbing = true;
            return true;
        } else if (this.isOn() && this.isGrabbing()) {
            this.grabbing = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return true if the arm is grabbing something
     */
    public boolean isGrabbing() {
        return grabbing;
    }
}