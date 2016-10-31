package it.unibo.oop.lab07.reflection02;

import it.unibo.oop.lab.exception01.PositionOutOfBoundException;

/**
 * Models a generic Robot.
 * 
 */
public class Robot {

    private static final int BATTERY_EMPTY = 0;
    private static final int MOVEMENT_DELTA = 1;
    private static final double MOVEMENT_DELTA_CONSUMPTION = 0.1;
    private static final double BATTERY_FULL = 100;

    private double batteryLevel;
    private final RobotEnvironment environment;
    private final String robotName;

    /**
     * 
     * @param robotName
     *            name of the robot
     * @param batteryLevel
     *            robot battery level
     */
    public Robot(final String robotName, final double batteryLevel) {
        this.batteryLevel = batteryLevel;
        this.environment = new RobotEnvironment(new RobotPosition(0, 0));
        this.robotName = robotName;
    }

    /**
     * Consume the amount of energy provided in input from the battery.
     * 
     * @param amount
     *            battery quantity to be consumed
     */
    protected void consumeBattery(final double amount) {
        if (batteryLevel >= amount) {
            this.batteryLevel -= amount;
        } else {
            this.batteryLevel = BATTERY_EMPTY;
        }
    }

    /**
     * Consume the amount of energy required to move the robot substracting it from the current battery level.
     */
    protected void consumeBatteryForMovement() {
        this.consumeBattery(Robot.MOVEMENT_DELTA_CONSUMPTION);
    }

    /**
     * 
     * @return The robot's current battery level
     */
    public double getBatteryLevel() {
        return (double) Math.round(this.batteryLevel * 100) / 100;
    }

    /**
     * 
     * @return The robot environment
     */
    public RobotEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * 
     * @return A boolean indicating if the robot has enough energy to move
     */
    protected boolean isBatteryEnoughToMove() {
        return this.getBatteryLevel() >= Robot.MOVEMENT_DELTA_CONSUMPTION;
    }

    /**
     * Lon in stdout the string provided in input.
     * 
     * @param msg
     *            the message to be logged
     */
    protected void log(final String msg) {
        System.out.println("[" + this.robotName + ":]" + msg);
    }

    /**
     * Moves the robot down by one unit.
     * 
     * @throws PositionOutOfBoundException
     *             if the movement is outside the {@link RobotEnvironment} boundaries
     * @throws NotEnoughBatteryException
     *             if the robot does not enough battery to move
     */
    public void moveDown() throws PositionOutOfBoundException, NotEnoughBatteryException {
        this.moveToPosition(this.environment.getCurrPosX(), environment.getCurrPosY() - Robot.MOVEMENT_DELTA);
    }

    /**
     * Moves the robot left by one unit.
     * 
     * @throws PositionOutOfBoundException
     *             if the movement is outside the {@link RobotEnvironment} boundaries
     * @throws NotEnoughBatteryException
     *             if the robot does not enough battery to move
     */
    public void moveLeft() throws PositionOutOfBoundException, NotEnoughBatteryException {
        this.moveToPosition(this.environment.getCurrPosX() - Robot.MOVEMENT_DELTA, this.environment.getCurrPosY());
    }

    /**
     * Moves the robot right by one unit.
     * 
     * @throws PositionOutOfBoundException
     *             if the movement is outside the {@link RobotEnvironment} boundaries
     * @throws NotEnoughBatteryException
     *             if the robot does not enough battery to move
     */
    public void moveRight() throws PositionOutOfBoundException, NotEnoughBatteryException {
        this.moveToPosition(this.environment.getCurrPosX() + Robot.MOVEMENT_DELTA, this.environment.getCurrPosY());
    }

    private void moveToPosition(final int newX, final int newY) throws PositionOutOfBoundException,
            NotEnoughBatteryException {
        if (this.isBatteryEnoughToMove()) {
            this.environment.move(newX, newY);
            this.consumeBatteryForMovement();
            this.log("Moved to position(" + newX + "," + newY + ").");
        } else {
            throw new NotEnoughBatteryException(this.getBatteryLevel(), Robot.MOVEMENT_DELTA_CONSUMPTION);
        }
    }

    /**
     * Moves the robot up by one unit.
     * 
     * @throws PositionOutOfBoundException
     *             if the movement is outside the {@link RobotEnvironment} boundaries
     * @throws NotEnoughBatteryException
     *             if the robot does not enough battery to move
     */
    public void moveUp() throws PositionOutOfBoundException, NotEnoughBatteryException {
        moveToPosition(environment.getCurrPosX(), this.environment.getCurrPosY() + Robot.MOVEMENT_DELTA);
    }

    /**
     * Fully recharge the robot.
     */
    public void recharge() {
        this.batteryLevel = BATTERY_FULL;
    }
}