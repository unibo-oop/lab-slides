package it.unibo.oop.lab.reflection01;

/**
 * 
 * A very trivial cloning exception.
 * 
 */
public class CloningException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4916530988414741100L;

    /**
     * Constructs a new cloning exception.
     * 
     * @param message
     *            the message to be associated with the exception
     */
    public CloningException(final String message) {
        super(message);
    }
}
