package it.unibo.oop.lab.reactivegui03;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ForkJoinPool;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * Third experiment with reactive gui.
 * 
 *
 */
public class AnotherConcurrentGUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;
    private static final int WAITING_TIME = 10000;

    private final JLabel display = new JLabel();
    private final JButton stop = new JButton("stop");
    private final JButton up = new JButton("up");
    private final JButton down = new JButton("down");

    private final CounterAgent counterAgent = new CounterAgent();

    /**
     * Builds a C3GUI.
     */
    public AnotherConcurrentGUI() {
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
        ForkJoinPool.commonPool().submit(counterAgent);
        ForkJoinPool.commonPool().submit(() -> {
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            AnotherConcurrentGUI.this.stopCounting();
        });
        up.addActionListener(e -> counterAgent.upCounting());
        down.addActionListener(e -> counterAgent.downCounting());
        stop.addActionListener(e -> stopCounting());
    }

    private void stopCounting() {
        counterAgent.stopCounting();
        SwingUtilities.invokeLater(() -> {
            stop.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(false);
        });
    }

    private class CounterAgent implements Runnable {
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
                } catch (InterruptedException | InvocationTargetException ex) {
                    ex.printStackTrace();
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
