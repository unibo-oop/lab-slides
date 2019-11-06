package it.unibo.oop.lab.advanced;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Graphical {@link DrawNumberView} implementation.
 */
public final class DrawNumberViewImpl implements DrawNumberView {

    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberViewObserver observer;
    private final JFrame frame = new JFrame(FRAME_NAME);

    /**
     * 
     */
    public DrawNumberViewImpl() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JPanel(new BorderLayout()));
        final JPanel pNorth = new JPanel(new FlowLayout());
        final JTextField tNumber = new JTextField(10);
        final JButton bGo = new JButton(GO);
        pNorth.add(tNumber);
        pNorth.add(bGo);
        final JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        final JButton bReset = new JButton(RESET);
        final JButton bQuit = new JButton(QUIT);
        pSouth.add(bReset);
        pSouth.add(bQuit);
        frame.getContentPane().add(pNorth, BorderLayout.NORTH);
        frame.getContentPane().add(pSouth, BorderLayout.SOUTH);
        bGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    observer.newAttempt(Integer.parseInt(tNumber.getText()));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "An integer please..");
                }
            }
        });
        bQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (confirmDialog("Confirm quitting?", "Quit")) {
                    observer.quit();
                }
            }
        });
        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (confirmDialog("Confirm resetting?", "Reset")) {
                    observer.resetGame();
                }
            }
        });

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }

    private boolean confirmDialog(final String question, final String name) {
        return JOptionPane.showConfirmDialog(frame, question, name,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    @Override
    public void setObserver(final DrawNumberViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void numberIncorrect() {
        JOptionPane.showMessageDialog(frame, "Incorrect Number.. try again", "Incorrect Number",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
        case YOURS_HIGH:
        case YOURS_LOW:
            plainMessage(res.getDescription());
            return;
        case YOU_WON:
            plainMessage(res.getDescription() + NEW_GAME);
            break;
        default:
            throw new IllegalStateException("Unexpected result: " + res);
        }
        observer.resetGame();
    }

    @Override
    public void limitsReached() {
        JOptionPane.showMessageDialog(frame, "You lost" + NEW_GAME, "Lost", JOptionPane.WARNING_MESSAGE);
    }

    private void plainMessage(final String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Result", JOptionPane.PLAIN_MESSAGE);
    }
}
