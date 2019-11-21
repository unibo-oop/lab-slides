package it.unibo.oop.lab.reactivegui02;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Second example of reactive GUI.
 */
public final class ConcurrentGUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;

    private final JLabel display = new JLabel();

    /**
     * Builds and shows the GUI.
     */
    public ConcurrentGUI() {
        super();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.add(display);
        final JButton stop = new JButton("stop");
        final JButton up = new JButton("up");
        final JButton down = new JButton("down");
        panel.add(up);
        panel.add(down);
        panel.add(stop);
        this.getContentPane().add(panel);
        this.setVisible(true);
        final Agent agent = new Agent();
        up.addActionListener(e -> agent.countUp());
        down.addActionListener(e -> agent.countDown());
        stop.addActionListener(e -> {
            agent.stopCounting();
            stop.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(false);
        });
        new Thread(agent).start();
    }

    private class Agent implements Runnable {
        private volatile boolean stop;
        private volatile boolean up = true;
        private int counter;

        @Override
        public void run() {
            while (!stop) {
                try {
                    counter += up ? 1 : -1;
                    /*
                     * Copy-pass + asynchronous update
                     * 
                     * All the processing happens in the local thread, EDT is only given charge to
                     * update the UI. It may lose graphical updates, but frees the current thread
                     * immediately and does not overload EDT
                     */
                    final var todisplay = Integer.toString(counter);
                    SwingUtilities.invokeLater(() ->
                        display.setText(todisplay)
                    );
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public void stopCounting() {
            this.stop = true;
        }

        public void countUp() {
            this.up = true;
        }

        public void countDown() {
            this.up = false;
        }
    }
}
