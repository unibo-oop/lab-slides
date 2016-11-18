package it.unibo.oop.rguis.mvc.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * An implementation of {@link CounterView}.
 *
 */
public class CounterGUI extends JFrame implements CounterView {

    // JFrame implementa Serializable, ricordarsi di generare l'UID
    private static final long serialVersionUID = -6218820567019985015L;

    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;

    // I componenti accessibili al Thread di conteggio siano campi
    private final JLabel display = new JLabel();
    private final JButton stop = new JButton("stop");

    private final Set<CounterViewObserver> observers;

    /**
     * Builds a new CGUI.
     */
    public CounterGUI() {
        super();
        this.observers = new HashSet<>();

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(stop);

        this.getContentPane().add(panel);

        // Si registra un listener che stoppa il contatore
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // agent dopra deve essere final
                for (final CounterViewObserver observer : observers) {
                    observer.stop();
                }
            }
        });

    }

    /**
     * {@inheritDoc}}.
     */
    public void initView() {
        this.setVisible(true);
    }

    /**
     * {@inheritDoc}}.
     */
    public void updateCounter(final int value) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    CounterGUI.this.display.setText(Integer.toString(value));
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}}.
     */
    public void addCounterViewObserver(final CounterViewObserver view) {
        this.observers.add(view);
    }
}
