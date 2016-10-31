package it.unibo.oop.lab.reflection01;

/**
 * 
 * A very trivial cloning exception.
 * 
 */
@SuppressWarnings("serial")
public class CloningException extends Exception {

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
