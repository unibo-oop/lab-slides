package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My second Java graphical interface");

    private SimpleGUIWithFileChooser(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel configuration
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        // Text area
        final JTextArea text = new JTextArea();
        // Save button
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    ctrl.save(text.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Assemble text and button
        panel1.add(text, BorderLayout.CENTER);
        panel1.add(save, BorderLayout.SOUTH);
        // File selection
        final JTextField filepath = new JTextField(ctrl.getCurrentFilePath());
        filepath.setEditable(false);
        final JButton chooseFile = new JButton("Browse...");
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fc = new JFileChooser("Choose where to save");
                fc.setSelectedFile(ctrl.getCurrentFile());
                final int result = fc.showSaveDialog(frame);
                switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    final File newDest = fc.getSelectedFile();
                    ctrl.setDestination(newDest);
                    filepath.setText(newDest.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, result, "Meh!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Assemble upper panel
        final JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(filepath, BorderLayout.CENTER);
        upperPanel.add(chooseFile, BorderLayout.LINE_END);
        panel1.add(upperPanel, BorderLayout.NORTH);
        // Frame configuration
        frame.setContentPane(panel1);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 4);
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }

    /**
     * @param a
     *            unused
     */
    public static void main(final String... a) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
