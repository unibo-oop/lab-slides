package it.unibo.oop.lab08.ex04;

/**
 * @author Danilo Pianini
 *
 */
public interface IView {

	/**
	 * Adds a new piece of data to be displayed.
	 * 
	 * @param name
	 *            the name
	 * @param surname
	 *            the surname
	 * @param code
	 *            the social security code
	 * @param birthYear
	 *            the year of birth
	 * @param male
	 *            true if the person is male
	 */
	void addData(String name, String surname, String code, int birthYear, boolean male);

	/**
	 * Changes the current {@link IController}.
	 * 
	 * @param listener
	 *            the new {@link IController}.
	 */
	void attachViewObserver(IController listener);

	/**
	 * Removes all the entries from this view.
	 */
	void clearData();

	/**
	 * Displays a message window with an error message.
	 * 
	 * @param message
	 *            the message to be displayed
	 */
	void commandFailed(String message);

}