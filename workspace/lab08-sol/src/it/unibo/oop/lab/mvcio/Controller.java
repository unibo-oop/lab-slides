package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";

    private File dest = new File(HOME + SEPARATOR + DEFAULT_FILE);

    /**
     * @return the current file
     */
    public File getCurrentFile() {
        return dest;
    }

    /**
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return dest.getPath();
    }

    /**
     * Saves some text on the designed file.
     * 
     * @param text
     *            the text to save
     * @throws IOException
     *             if the writing fails
     */
    public void save(final String text) throws IOException {
        try (PrintStream out = new PrintStream(dest)) {
            out.println(text);
        }
    }

    /**
     * @param file
     *            the file where to write
     */
    public void setDestination(final File file) {
        final File parent = file.getParentFile();
        if (parent.exists()) {
            dest = file;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }

    /**
     * @param file
     *            the file where to write
     */
    public void setDestination(final String file) {
        setDestination(new File(file));
    }

}
