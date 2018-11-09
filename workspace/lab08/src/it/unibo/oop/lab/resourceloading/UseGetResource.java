package it.unibo.oop.lab.resourceloading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Example class loading an image with {@link Class#getResource(String)}.
 *
 */
public final class UseGetResource {

    private UseGetResource() {
    }

    /**
     * @param args
     *            Ignored
     * @throws IOException if an I/O error occurs
     */
    public static void main(final String... args) throws IOException {
        /*
         * Access resources as streams
         */
        final InputStream in = ClassLoader.getSystemResourceAsStream("settings/settings");
        String line = "Error accessing the resource";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            line = br.readLine();
        }
        final JLabel lab2 = new JLabel(line);
        /*
         * Loading of icons and images is made very easy!
         */
        final URL imgURL = ClassLoader.getSystemResource("images/gandalf.jpg");
        final ImageIcon icon = new ImageIcon(imgURL);
        /*
         * From now on, it's just plain GUI construction
         */
        final JLabel lab1 = new JLabel(icon);
        final JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.add(lab1);
        pan.add(lab2);
        final JFrame f = new JFrame("Image loader");
        f.getContentPane().add(pan);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

}
