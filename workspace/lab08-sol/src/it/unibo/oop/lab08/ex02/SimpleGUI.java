package it.unibo.oop.lab08.ex02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 * @author Danilo Pianini
 *
 */
public final class SimpleGUI extends JFrame {

	private static final long serialVersionUID = 1760990730218643730L;

	private static enum Command {
		SAVE;
		
		private boolean checkCommand(final ActionEvent ev) {
			return ev.getActionCommand().equals(toString());
		}

	}

	private final Controller ctrl = new Controller();
	private final JTextArea text = new JTextArea();

	private SimpleGUI() {
		super("My first Java graphical interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel1 = new JPanel();
		final LayoutManager layout = new BorderLayout();
		panel1.setLayout(layout);
		final JButton save = new JButton("Save");
		save.setActionCommand(Command.SAVE.toString());
		save.addActionListener(new SimpleGUIListner());
		panel1.add(text, BorderLayout.CENTER);
		panel1.add(save, BorderLayout.SOUTH);

		setContentPane(panel1);

		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int sw = (int) screen.getWidth();
		final int sh = (int) screen.getHeight();
		setSize(sw / 2, sh / 2);

		setLocationByPlatform(true);
	}

	/**
	 * @param a
	 *            unused
	 */
	public static void main(final String[] a) {
		final SimpleGUI gui = new SimpleGUI();
		gui.setVisible(true);
	}

	private class SimpleGUIListner implements ActionListener {
		
		@Override
		public void actionPerformed(final ActionEvent ev) {
			if (Command.SAVE.checkCommand(ev)) {
				try {
					ctrl.save(text.getText());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}
	
}
