package it.unibo.oop.lab.reflection02;

/**
 * Abstract class to use as a basis to implement a robotic part that can perform
 * move operation (e.g. actuators).
 * 
 */
public abstract class AbstractMovementPart implements RobotPart {

    private boolean on;
    private final String description;
    private final double energyRequiredToMove;

    /**
     * 
     * @param energyRequiredToMove
     *            energy required for a movement
     * @param description
     *            a description of this robot part
     */
    public AbstractMovementPart(final double energyRequiredToMove, final String description) {
        this.description = description;
        this.energyRequiredToMove = energyRequiredToMove;
    }

    /**
     * {@inheritDoc}
     */
    public boolean turnOn() {
        if (!this.on) {
            this.on = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean turnOff() {
        if (this.on) {
            this.on = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return this.getDescription();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return The amount of energy required for move this IRobotPart
     */
    public double getEnergyRequiredForMoving() {
        return energyRequiredToMove;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public boolean isOn() {
        return this.on;
    }

    /**
     * 
     * @return A boolean indicating if the movement hav been performed with
     *         success or not
     */
    public abstract boolean doMove();
}