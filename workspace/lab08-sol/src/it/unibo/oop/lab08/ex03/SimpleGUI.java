package it.unibo.oop.lab08.ex03;

import it.unibo.oop.lab08.ex02.Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 * @author Danilo Pianini
 *
 */
public final class SimpleGUI extends JFrame {

	private static final long serialVersionUID = 1760990730218643730L;

	private static enum Command {
		SAVE, SETFILE;
		
		private boolean checkCommand(final ActionEvent ev) {
			return ev.getActionCommand().equals(toString());
		}
	}

	private final Controller ctrl = new Controller();
	private final JTextArea text = new JTextArea();
	private final JTextField filepath = new JTextField(ctrl.getCurrentFilePath());

	private SimpleGUI() {
		super("My second Java graphical interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final SimpleGUIListner listener = new SimpleGUIListner(this);
		
		final JPanel panel1 = new JPanel();
		final LayoutManager layout = new BorderLayout();
		panel1.setLayout(layout);
		final JButton save = new JButton("Save");
		save.setActionCommand(Command.SAVE.toString());
		save.addActionListener(listener);
		panel1.add(text, BorderLayout.CENTER);
		panel1.add(save, BorderLayout.SOUTH);

		final JPanel upperPanel = new JPanel();
		final LayoutManager upperLayout = new BorderLayout();
		upperPanel.setLayout(upperLayout);
		panel1.add(upperPanel, BorderLayout.NORTH);

		filepath.setEditable(false);
		upperPanel.add(filepath, BorderLayout.CENTER);
		
		final JButton chooseFile = new JButton("Browse...");
		chooseFile.setActionCommand(Command.SETFILE.toString());
		chooseFile.addActionListener(listener);
		upperPanel.add(chooseFile, BorderLayout.LINE_END);

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
		
		private final JFrame parent;
		
		SimpleGUIListner(final JFrame f) {
			parent = f;
		}
		
		@Override
		public void actionPerformed(final ActionEvent ev) {
			if (Command.SAVE.checkCommand(ev)) {
				try {
					ctrl.save(text.getText());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
				}
			} else if (Command.SETFILE.checkCommand(ev)) {
				final JFileChooser fc = new JFileChooser("Choose where to save");
				fc.setSelectedFile(ctrl.getCurrentFile());
				final int result = fc.showSaveDialog(parent);
				switch (result) {
				case JFileChooser.APPROVE_OPTION:
					final File newDest = fc.getSelectedFile();
					ctrl.setDestination(newDest);
					filepath.setText(newDest.getPath());
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				default:
					JOptionPane.showMessageDialog(parent, "Something went wrong. Check stdout", "Meh!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

}
