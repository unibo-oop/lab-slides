package it.unibo.oop.lab08.ex04;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public interface IController {

	/**
	 * Loads the list of people from the local file system.
	 */
	void commandLoad();

	/**
	 * Saves the list of people to the local file system.
	 */
	void commandSave();

	/**
	 * Adds a new person.
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
	void commandAdd(String name, String surname, String code, int birthYear, boolean male);

	/**
	 * Ordinately shuts down the program.
	 */
	void commandQuit();

	/**
	 * Refreshes the status of each attached view.
	 */
	void commandResend();

	/**
	 * Adds a view to this controller.
	 * 
	 * @param v
	 *            the view to add
	 */
	void addView(IView v);

	/**
	 * Removes a view from this controller.
	 * 
	 * @param v
	 *            the view to remove
	 */
	void removeView(IView v);
}
