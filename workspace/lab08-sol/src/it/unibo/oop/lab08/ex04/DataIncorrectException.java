package it.unibo.oop.lab08.ex04;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public class DataIncorrectException extends Exception {

	private static final long serialVersionUID = -2800415427549132934L;

	/**
	 * @param message
	 *            the message
	 */
	public DataIncorrectException(final String message) {
		super(message);
	}

}
