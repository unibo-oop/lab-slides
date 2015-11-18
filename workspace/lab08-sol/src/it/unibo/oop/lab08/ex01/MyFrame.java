package it.unibo.oop.lab08.ex01;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = -8476554667089604958L;

	/**
	 * @param title
	 *            the window title
	 * @param lm
	 *            the layoutmanager for the main panel
	 */
	public MyFrame(final String title, final LayoutManager lm) {

		super(title);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JPanel(lm));

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
		setSize(sw / 4, sh / 4);

		/*
		 * Instead of appearing at (0,0), upper left corner of the screen, this
		 * flag makes the OS window manager take care of the default positioning
		 * on screen. Results may vary, but it is generally the best choice.
		 */
		setLocationByPlatform(true);
	}

	/**
	 * @return the main {@link JPanel}
	 */
	public JPanel getMainPanel() {
		return (JPanel) this.getContentPane().getComponent(0);
	}

}
