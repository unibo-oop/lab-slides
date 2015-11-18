package it.unibo.oop.lab08.ex04;

import java.util.Iterator;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public interface IModel extends Iterable<Person> {

	/**
	 * Removes all the people.
	 */
	void clear();

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
	 * @throws DataIncorrectException
	 *             If the data entered is not correct
	 */
	void add(String name, String surname, String code, int birthYear, boolean male) throws DataIncorrectException;

	@Override
	Iterator<Person> iterator();

}
