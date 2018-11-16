package it.unibo.oop.lab.reflectivegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * A Panel that is able to load and inspect classes.
 */
public class ClassExplorer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel center;

    /**
     * 
     */
    public ClassExplorer() {
        setLayout(new BorderLayout());
        final JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
        north.add(new JLabel("Class name:"));
        final JTextField classNameField = new JTextField(ClassExplorer.class.getName().length() * 2);
        north.add(classNameField);
        final JButton load = new JButton("Load");
        load.addActionListener(event -> {
            try {
                final Class<?> clazz = Class.forName(classNameField.getText());
                if (center != null) {
                    remove(center);
                }
                center = new JPanel();
                center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
                center.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                for (final Method m: clazz.getMethods()) {
                    center.add(new MethodPanel(m));
                }
                add(new JScrollPane(center), BorderLayout.CENTER);
                revalidate();
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Class " + classNameField.getText() + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        north.add(load);
        add(north, BorderLayout.NORTH);
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        final JFrame frame = new JFrame("Class explorer");
        frame.setContentPane(new ClassExplorer());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}
