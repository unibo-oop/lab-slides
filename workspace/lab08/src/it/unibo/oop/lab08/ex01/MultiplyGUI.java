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
public final class MultiplyGUI {

	private MultiplyGUI() {
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

		final JTextField tf = new JTextField(10);
		final JLabel lb = new JLabel(" Result : 0");

		final JButton bt = new JButton(" Multiply by 2");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				lb.setText(" Result :" + Integer.parseInt(tf.getText()) * 2);
			}
		});

		final FlowLayout lay = new FlowLayout(FlowLayout.CENTER, 10, 10);
		final MyFrame frame = new MyFrame("Multiply", lay);
		frame.getMainPanel().add(tf);
		frame.getMainPanel().add(lb);
		frame.getMainPanel().add(bt);
		frame.setVisible(true);
	}
}