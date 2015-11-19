package it.unibo.oop.lab08.ex02;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) I has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) Its components register to a private inner class that implements
     * ActionListener for its event handling. SUGGESTION: rely on
     * setActionCommand() and check the commands to understand which component
     * generated the event
     * 
     * 4) The graphical interface consists of a JTextArea with a button "Save"
     * right below (see ex1.png for the expected result). SUGGESTION: Use a
     * JPanel with BorderLayout
     * 
     * 5) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 6) The behavior of the program is that, if "Save" is pressed, the
     * controller is asked to save the file.
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {

        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }

}
