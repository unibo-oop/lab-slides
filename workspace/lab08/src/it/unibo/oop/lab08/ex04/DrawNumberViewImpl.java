package it.unibo.oop.lab08.ex04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrawNumberViewImpl implements DrawNumberView {

    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";

    private DrawNumberViewObserver observer;
    private final JFrame frame = new JFrame(FRAME_NAME);

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
            public void actionPerformed(final ActionEvent e) {
                try {
                    observer.newAttempt(Integer.parseInt(tNumber.getText()));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "An integer please..");
                }
            }
        });
        bQuit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (confirmDialog("Confirm quitting?", "Quit")) {
                    observer.quit();
                }
            }
        });
        bReset.addActionListener(new ActionListener() {
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
    public void limitsReached() {
        JOptionPane.showMessageDialog(frame, "You lost.. a new game starts", "Lost", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
        case YOURS_HIGH:
            JOptionPane.showMessageDialog(frame, "Your number is too high", "Result", JOptionPane.PLAIN_MESSAGE);
            return;
        case YOURS_LOW:
            JOptionPane.showMessageDialog(frame, "Your number is too low", "Result", JOptionPane.PLAIN_MESSAGE);
            return;
        case YOU_WON:
            JOptionPane.showMessageDialog(frame, "You won the game!!", "Result", JOptionPane.PLAIN_MESSAGE);
            observer.resetGame();
            return;
        case YOU_LOSE:
            limitsReached();
        default:
            break;
        }
    }
}
