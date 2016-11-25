package it.unibo.oop.lab09.reactivegui2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * Second example of reactive GUI.
 *
 */
public class ConcurrentGUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;

    private final JLabel display = new JLabel();
    private final JButton stop = new JButton("stop");
    private final JButton up = new JButton("up");
    private final JButton down = new JButton("down");

    /**
     * Construct a C2GUI.
     */
    public ConcurrentGUI() {
        super();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(up);
        panel.add(down);
        panel.add(stop);

        this.getContentPane().add(panel);
        this.setVisible(true);

        final Agent agent = new Agent();
        agent.start();

        up.addActionListener(new ActionListener() {
            /**
             * Action listener.
             * 
             * @param evt
             *            the event to be handled.
             * 
             */
            @Override
            public void actionPerformed(final ActionEvent evt) {
                agent.upCounting();
            }
        });

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                agent.downCounting();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                agent.stopCounting();
                stop.setEnabled(false);
                up.setEnabled(false);
                down.setEnabled(false);
            }
        });

    }

    private class Agent extends Thread {

        private volatile boolean stop;
        private volatile boolean up = true;
        private int counter;

        public void run() {
            while (!stop) {
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {
                            display.setText(Integer.toString(counter));
                        }
                    });
                    counter += up ? 1 : -1;

                    Thread.sleep(100);
                } catch (InvocationTargetException | InterruptedException ex) {
                    // interrupted: added a system.out but there are much better ways to log exceptions
                    System.out.println("Something went wrong. " + ex);
                }
            }
        }

        public void stopCounting() {
            this.stop = true;
        }

        public void upCounting() {
            this.up = true;
        }

        public void downCounting() {
            this.up = false;
        }
    }
}
