package it.unibo.oop.lab08.ex03;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * A very simple program using a graphical interface.
 * 
 * @author Danilo Pianini
 *
 */
public final class SimpleGUI extends JFrame {

	private static final long serialVersionUID = 1760990730218643730L;

	/*
	 * TODO: Starting from the application in ex01:
	 * 
	 * 1) Add a JTextField and a button "Browse..." on the upper part of the
	 * graphical interface. To see which should be the result, see ex02.png.
	 * Suggestion: use a second JPanel with a second BorderLayout, put the panel
	 * in the North of the main panel, put the text field in the center of the
	 * new panel and put the button in the line_end of the new panel.
	 * 
	 * 2) The JTextField should be non modifiable. And, should display the
	 * current selected file.
	 * 
	 * 3) On press, the button should open a JFileChooser. The program should
	 * use the method showSaveDialog() to display the file chooser, and if the
	 * result is equal to JFileChooser.APPROVE_OPTION the program should set as
	 * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
	 * then the program should do nothing. Otherwise, a message dialog should be
	 * shown telling the user that an error has occurred (use
	 * JOptionPane.showMessageDialog()).
	 * 
	 * 4) When in the controller a new File is set, also the graphical interface
	 * must reflect such change. Suggestion: do not force the controller to
	 * update the UI: in this example the UI knows when should be updated, so
	 * try to keep things separated.
	 */

	/**
	 * builds a new {@link SimpleGUI}.
	 */
	public SimpleGUI() {

		/*
		 * Make the frame half the resolution of the screen. This very method is
		 * enough for a single screen setup. In case of multiple monitors, the
		 * primary is selected. In order to deal coherently with multimonitor
		 * setups, other facilities exist (see the Java documentation about this
		 * issue). It is MUCH better than manually specify the size of a window
		 * in pixel: it takes into account the current resolution.
		 */
		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int sw = (int) screen.getWidth();
		final int sh = (int) screen.getHeight();
		setSize(sw / 2, sh / 2);

		/*
		 * Instead of appearing at (0,0), upper left corner of the screen, this
		 * flag makes the OS window manager take care of the default positioning
		 * on screen. Results may vary, but it is generally the best choice.
		 */
		setLocationByPlatform(true);
	}

}
