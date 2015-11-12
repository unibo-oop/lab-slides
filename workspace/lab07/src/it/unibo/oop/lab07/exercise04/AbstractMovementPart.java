package it.unibo.oop.lab07.exercise04;

/**
 * Abstract class to use as a basis to implement a robotic part that can perform
 * move operation (e.g. actuators).
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public abstract class AbstractMovementPart implements IRobotPart {

    private boolean isOn;
    private final String description;
    private final double energyRequiredToMove;

    /**
     * 
     * @param energyRequiredToMove
     * @param description
     */
    public AbstractMovementPart(final double energyRequiredToMove,
            final String description) {
        this.description = description;
        this.energyRequiredToMove = energyRequiredToMove;
    }

    /**
     * @return true if the part has turned successfully on
     */
    public boolean turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return true if the part has turned successfully off
     */
    public boolean turnOff() {
        if (this.isOn) {
            this.isOn = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    /**
     * 
     * @return return the description of this part
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
     * @return true is this part is on
     */
    public boolean isOn() {
        return this.isOn;
    }

    /**
     * 
     * @return A boolean indicating if the movement hav been performed with
     *         success or not
     */
    public abstract boolean doMove();
}