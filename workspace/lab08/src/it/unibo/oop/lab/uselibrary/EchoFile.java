package it.unibo.oop.lab.uselibrary;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

/**
 * Example class using Apache Commons I/O. (no good Java programmer in 2017
 * still uses streams manually for access to files unless strictly required...)
 */
public final class EchoFile {

    private EchoFile() { }

    /**
     * @param args arguments list, used to fetch files.
     * @throws IOException 
     */
    public static void main(final String... args) throws IOException {
        if (args.length == 0) {
            System.out.println("At least an argument is required for this program to work.");
        }
        for (final String fileName: args) {
            final File file = new File(fileName);
            System.out.println(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
        }
    }

}
