package it.unibo.oop.lab07.exercise04;

/**
 * Models a (x,y) position for a {@link it.unibo.oop.lab07.exercise04.Robot}.
 * 
 */
public class RobotPosition {

    private int x;
    private int y;

    /**
     * 
     * @param x
     *            x position of the robot
     * @param y
     *            y position of the robot
     */
    public RobotPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return robot's x position
     */
    public int getX() {
        return this.x;
    }

    /**
     * 
     * @param x
     *            set robot x position
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * 
     * @return robot y position
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @param y
     *            set robot's y position
     */
    public void setY(final int y) {
        this.y = y;
    }
}