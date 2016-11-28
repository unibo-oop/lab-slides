package it.unibo.oop.lab.mvc.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.unibo.oop.lab.mvc.controller.CounterController;

/**
 * An implementation of {@link CounterView}.
 *
 */
public final class CounterGUI extends JFrame implements CounterView {

    private static final long serialVersionUID = 1L;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;
    private final JLabel display = new JLabel();
    private final JButton start = new JButton("start");
    private final JButton stop = new JButton("stop");

    /**
     * Builds a new GUI.
     * 
     * @param controller
     *            the controller to act upon
     */
    public CounterGUI(final CounterController controller) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(start);
        panel.add(stop);
        start.addActionListener(e -> controller.start());
        stop.setEnabled(false);
        stop.addActionListener(e -> controller.stop());
        this.getContentPane().add(panel);
    }

    /**
     * {@inheritDoc}}.
     */
    @Override
    public void init() {
        SwingUtilities.invokeLater(() -> {
            start.setEnabled(false);
            stop.setEnabled(true);
            setText(0);
        });
    }

    @Override
    public void terminate() {
        SwingUtilities.invokeLater(() -> {
            start.setEnabled(true);
            stop.setEnabled(false);
        });
    }

    private void setText(final int i) {
        display.setText(Integer.toString(i));
    }

    /**
     * {@inheritDoc}}.
     */
    public void update(final int value) {
        uncheckedInvokeAndWait(() -> display.setText(Integer.toString(value)));
    }

    private static void uncheckedInvokeAndWait(final Runnable r) {
        try {
            SwingUtilities.invokeAndWait(r);
        } catch (InvocationTargetException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
