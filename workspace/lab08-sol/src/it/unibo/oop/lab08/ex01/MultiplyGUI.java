package it.unibo.oop.lab08.ex01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public final class MultiplyGUI extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 654605589473091019L;

	/**
	 * Builds a new {@link MultiplyGUI}.
	 */
	private MultiplyGUI() {
		super("Multiply", new FlowLayout(FlowLayout.CENTER));
		final JTextField tf = new JTextField(10);
		final JLabel lb = new JLabel(" Result : 0");

		final JButton bt = new JButton(" Multiply by 2");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				lb.setText(" Result :" + Integer.parseInt(tf.getText()) * 2);
			}
		});

		getMainPanel().add(tf);
		getMainPanel().add(lb);
		getMainPanel().add(bt);
	}

	/**
	 * @param args
	 *            ignored
	 */
	public static void main(final String[] args) {

		/*
		 * This is the program you have already seen during lectures, with
		 * minimal modifications.
		 * 
		 * 1) Open MyFrame.java, and look at the changes between this version
		 * and the previous one. Carefully read the comments.
		 * 
		 * 2) Refactor this class in such a way that it becomes a subclass of
		 * MyFrame.
		 * 
		 * 3) Move the whole initialization of the UI inside the constructor,
		 * the main() method should only contain the frame building and its
		 * displaying on screen.
		 */
		new MultiplyGUI().setVisible(true);
	}
}