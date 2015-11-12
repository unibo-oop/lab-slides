package it.unibo.oop.lab07.exercise04;

import java.util.Arrays;

/**
 * Concrete implementation of a robot composed by a set of generic
 * {@link it.unibo.oop.lab07.exercise04.IRobotPart}.
 * 
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
    public ComposableRobot(final String robotName, final IRobotPart[] parts, final double batteryLevel) {
        super(robotName, batteryLevel);
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    /**
     * @return the array of the robot composing parts.
     */
    public IRobotPart[] getParts() {
        return Arrays.copyOf(this.parts, this.parts.length);
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
        for (final IRobotPart part : this.parts) {
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
        for (final IRobotPart part : this.parts) {
            this.log("Current status for part " + part.getDescription() + " is: " + part.isOn());
        }
    }

    /**
     * Turn on all the {@link it.unibo.oop.lab07.IRobotPart} invoking the method
     * {@link it.unibo.oop.lab07.IRobotPart#turnOn()} for each one of them.
     */
    public void turnOnAll() {
        for (final IRobotPart part : this.parts) {
            this.log("Turning on part " + part.getDescription());
            try {
                part.turnOn();
            } catch (CantTurnOnException e) {
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
        for (final IRobotPart part : this.parts) {
            this.log("Turning off part " + part.getDescription());
            try {
                part.turnOff();
            } catch (CantTurnOffException e) {
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
        this.consumeBattery(this.parts.length * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
    }

    /**
     * 
     * @author Matteo Casadei
     *
     */
    public static class RobotWithTwoArms extends ComposableRobot {
        private static final String LEFT_ARM = "Left Arm";
        private static final String RIGTH_ARM = "Right Arm";

        /**
         * 
         * @param robotName
         *            name of robot
         * @param batteryLevel
         *            initial battery level
         */
        public RobotWithTwoArms(final String robotName, final double batteryLevel) {
            super(robotName, new IRobotPart[] { new RobotArm(LEFT_ARM), new RobotArm(RIGTH_ARM) }, batteryLevel);
        }
    }

    /**
     * 
     * @author Matteo Casadei
     *
     */
    public static class RobotWithTwoArmsAndHead extends ComposableRobot {
        private static final String LEFT_ARM = "Left Arm";
        private static final String RIGTH_ARM = "Right Arm";
        private static final String HEAD_DESCRIPTION = "Robot head";

        /**
         * 
         * @param robotName
         *            name of robot
         * @param batteryLevel
         *            initial battery level
         */
        public RobotWithTwoArmsAndHead(final String robotName, final double batteryLevel) {
            super(robotName,
                    new IRobotPart[] { new RobotArm(LEFT_ARM), new RobotArm(RIGTH_ARM), new RobotHead(HEAD_DESCRIPTION) },
                    batteryLevel);
        }
    }

    /**
     * 
     * @author Matteo Casadei
     *
     */
    public static class RobotWithHead extends ComposableRobot {
        private static final String HEAD_DESCRIPTION = "Robot head";

        /**
         * 
         * @param robotName
         *            name of robot
         * @param batteryLevel
         *            initial battery level
         */
        public RobotWithHead(final String robotName, final double batteryLevel) {
            super(robotName, new IRobotPart[] { new RobotHead(HEAD_DESCRIPTION) }, batteryLevel);
        }
    }
}