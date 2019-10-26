package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot overcomes the boundaries of
 * its environment.
 * 
 */
public class PositionOutOfBoundException extends IllegalStateException {

    /**
     * The reason why this strange long field exists will be clear after the lesson
     * about I/O in Java...
     */
    private static final long serialVersionUID = 1L;
    private final int x;
    private final int y;

    /**
     * Construct new instance of the exception.
     * 
     * @param initX
     *            position on X that caused the exception
     * @param initY
     *            position on Y that caused the exception
     */
    public PositionOutOfBoundException(final int initX, final int initY) {
        super();
        this.x = initX;
        this.y = initY;
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return "Can not move to pos(" + this.x + ", " + this.y + "), out of bounds";
    }
}
