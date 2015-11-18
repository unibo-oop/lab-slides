package it.unibo.oop.lab08.ex04;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public class Model extends HashSet<Person> implements IModel {

	private static final long serialVersionUID = 131818814922065489L;

	private static final String WRONG_NAME = "Wrong name";
	private static final String WRONG_SURNAME = "Wrong surname";
	private static final String WRONG_CODE = "Wrong code";
	private static final String WRONG_YEAR = "Wrong birth year";
	private static final int CURRENT_YEAR = LocalDate.now().getYear();
	private static final int LONGEST_UMAN_LIFE = 150;
	private static final int MINIMUM_YEAR = CURRENT_YEAR - LONGEST_UMAN_LIFE;

	@Override
	public void add(final String name, final String surname, final String code, final int birthYear, final boolean male)
			throws DataIncorrectException {
		String message = null;
		if (name == null || name.length() == 0) {
			message = WRONG_NAME;
		}
		if (surname == null || surname.length() == 0) {
			message = WRONG_SURNAME;
		}
		if (code == null || code.length() < 10) {
			message = WRONG_CODE;
		}
		if (birthYear < MINIMUM_YEAR || birthYear > CURRENT_YEAR) {
			message = WRONG_YEAR;
		}
		if (message == null) {
			this.add(new Person(name, surname, code, birthYear, male));
		} else {
			throw new DataIncorrectException(message);
		}
	}

	@Override
	public Iterator<Person> sortedIterator() {
		final SortedSet<Person> ts = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(final Person o1, final Person o2) {
				return o1.getCode().compareTo(o2.getCode());
			}

		});
		ts.addAll(this);
		return ts.iterator();
	}

}
