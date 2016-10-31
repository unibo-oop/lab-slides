package it.unibo.oop.lab.reflection02;

import it.unibo.oop.lab.exception01.PositionOutOfBoundException;

/**
 * Models the environment in which a {@link Robot} is
 * situated.
 *
 */
public class RobotEnvironment {

    /**
     * Environment upper bound for the X coordinate.
     */
    public static final int WORLD_X_UPPER_LIMIT = 50;
    /**
     * Environment lower bound for the X coordinate.
     */
    public static final int WORLD_X_LOWER_LIMIT = 0;
    /**
     * Environment upper bound for the Y coordinate.
     */
    public static final int WORLD_Y_UPPER_LIMIT = 80;
    /**
     * Environment lower bound for the X coordinate.
     */
    public static final int WORLD_Y_LOWER_LIMIT = 0;

    private final RobotPosition position;

    /**
     * 
     * @param position
     *            robot initial pos
     */
    public RobotEnvironment(final RobotPosition position) {
        this.position = position;
    }

    /**
     * Move the robot to a new position.
     * 
     * @param newX
     *            new X pos
     * @param newY
     *            new Y pos
     * @throws PositionOutOfBoundException
     *             if the movement is outside the boundaries
     */
    public void move(final int newX, final int newY) throws PositionOutOfBoundException {
        if ((newX >= RobotEnvironment.WORLD_X_LOWER_LIMIT && newX <= RobotEnvironment.WORLD_X_UPPER_LIMIT)
                && (newY >= RobotEnvironment.WORLD_Y_LOWER_LIMIT && newY <= RobotEnvironment.WORLD_Y_UPPER_LIMIT)) {
            this.position.setX(newX);
            this.position.setY(newY);
        } else {
            throw new PositionOutOfBoundException(newX, newY);
        }
    }

    /**
     * @return Current X position
     */
    public int getCurrPosX() {
        return this.position.getX();
    }

    /**
     * 
     * @return Current Y position
     */
    public int getCurrPosY() {
        return this.position.getY();
    }
}