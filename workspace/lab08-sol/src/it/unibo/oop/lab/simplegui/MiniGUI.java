package it.unibo.oop.lab.simplegui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is a simple application that writes a random number on a file.
 * 
 * This application does not exploit the model-view-controller pattern, and as
 * such is just to be used to learn the basics, not as a template for your
 * applications.
 */
public class MiniGUI {

    private static final String TITLE = "A very simple GUI application";
    private static final String RESULT_TXT_CONTENT = "Result";
    private static final int PROPORTION = 5;
    private final Random rng = new Random();
    private final JFrame frame = new JFrame(TITLE);

    /**
     * 
     */
    public MiniGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        /*
         * EX 01.01
         */
        final JPanel aPanel = new JPanel();
        aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.LINE_AXIS));
        canvas.add(aPanel, BorderLayout.CENTER);
        final JButton write = new JButton("Print a random number on standard output");
        aPanel.add(write);
        /*
         * EX 01.02
         */
        final JTextField result = new JTextField(RESULT_TXT_CONTENT);
        canvas.add(result, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                /*
                 * EX 01.03
                 */
                final int res = rng.nextInt();
                System.out.println(res);
                result.setText(RESULT_TXT_CONTENT + ": " + Integer.toString(res));
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very
         * method is enough for a single screen setup. In case of multiple
         * monitors, the primary is selected. In order to deal coherently with
         * multimonitor setups, other facilities exist (see the Java
         * documentation about this issue). It is MUCH better than manually
         * specify the size of a window in pixel: it takes into account the
         * current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * Resize the frame to minimum size
         */
        frame.pack();
        /*
         * OK, ready to pull the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        new MiniGUI().display();
    }

}
