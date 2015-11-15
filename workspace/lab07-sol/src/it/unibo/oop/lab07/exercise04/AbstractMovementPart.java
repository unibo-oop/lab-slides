package it.unibo.oop.lab07.exercise04;

/**
 * Abstract class to use as a basis to implement a robotic part that can perform
 * move operation (e.g. actuators).
 * 
 */
public abstract class AbstractMovementPart implements IRobotPart {

    private boolean on;
    private final String description;
    private final double energyRequiredToMove;

    /**
     * 
     * @param energyRequiredToMove
     *            battery level required
     * @param description
     *            part description
     */
    public AbstractMovementPart(final double energyRequiredToMove, final String description) {
        this.description = description;
        this.energyRequiredToMove = energyRequiredToMove;
    }

    /**
     * @return true if this can be activated
     * @throws CantTurnOnException
     *             if the part cannot be activated
     */
    public boolean turnOn() throws CantTurnOnException {
        if (!this.on) {
            this.on = true;
            return true;
        } else {
            throw new CantTurnOnException();
        }
    }

    /**
     * @return true if this can be switched off
     * @throws CantTurnOffException
     *             if this cannot be deactivated
     */
    public boolean turnOff() throws CantTurnOffException {
        if (this.on) {
            this.on = false;
            return true;
        } else {
            throw new CantTurnOffException();
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
        return this.on;
    }

    /**
     * 
     * @return A boolean indicating if the movement hav been performed with
     *         success or not
     */
    public abstract boolean doMove();
}