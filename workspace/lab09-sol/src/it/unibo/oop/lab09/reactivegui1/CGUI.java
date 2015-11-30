package it.unibo.oop.lab09.reactivegui1;


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
 * This is a first example on how to realize a reactive GUI.
 *
 */
public class CGUI extends JFrame {

    // JFrame implementa Serializable, ricordarsi di generare l'UID
    private static final long serialVersionUID = -6218820567019985015L;

    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;

    // I componenti accessibili al Thread di conteggio siano campi
    private final JLabel display = new JLabel();
    private final JButton stop = new JButton("stop");

    /**
     * Builds a new CGUI.
     */
    public CGUI() {
        super();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(stop);

        this.getContentPane().add(panel);
        this.setVisible(true);

        // Si crea l'agent contatore e lo si fa partire
        final Agent agent = new Agent();
        agent.start();

        // Si registra un listener che stoppa il contatore
        stop.addActionListener(new ActionListener() {
            /**
             * event handler associated to action event on button stop.
             * 
             * @param e
             *            the action event that will be handled by this listener
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                // agent dopra deve essere final
                agent.stopCounting();
            }
        });

    }

    /**
     * Il contatore è realizzato tramite una member class provata che estende
     * Thread. Questo consente di tenerla invisibile all'esterno, ben
     * incapsulata, e le consente di accedere ai campi dell'enclosing instance,
     * ossia ai componenti della GUI che potrebbe modificare.
     * 
     */
    private class Agent extends Thread {

        // stop viene modificato "da fuori": sia volatile!!
        private volatile boolean stop;
        private int counter;

        /**
         * Behavior of thread.
         */
        public void run() {
            // Solito ciclo per supportare deferred cancellation
            while (!this.stop) {
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {
                            CGUI.this.display.setText(Integer.toString(Agent.this.counter));
                            // or simply:
                            // display.setText("" + counter);
                        }
                    });
                    // Incremento il conteggio e dormo per 100 msec
                    this.counter++;

                    Thread.sleep(100);
                } catch (InvocationTargetException | InterruptedException ex) {
                    // interrupted: added a system.out but there are much better ways to log exceptions
                    System.out.println("Something went wrong. " + ex);
                }
            }
        }

        /**
         * Excternal command to stop counting.
         */
        public void stopCounting() {
            this.stop = true;
        }
    }
}
