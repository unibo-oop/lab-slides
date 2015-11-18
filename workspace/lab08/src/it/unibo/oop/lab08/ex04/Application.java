package it.unibo.oop.lab08.ex04;

/**
 * 
 * 
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public final class Application {

	private static final String HOME = System.getProperty("user.home");
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String DEFAULT_FILE = "data.dat";

	private Application() {
	}

	/**
	 * @param args
	 *            ignored
	 */
	public static void main(final String[] args) {
		final Controller c = new Controller();
		c.setFileName(HOME + SEPARATOR + DEFAULT_FILE);
		final View v = new View();
		c.addView(v);
	}
}
