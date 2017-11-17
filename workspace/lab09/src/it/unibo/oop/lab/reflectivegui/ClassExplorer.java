package it.unibo.oop.lab.reflectivegui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
            /*
             * Load the class with the name specified in the text field. In case of failure,
             * display an error message.
             */
            final Class<?> clazz = null;
//            JOptionPane.showMessageDialog(this, "Class " + classNameField.getText() + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            if (center != null) {
                remove(center);
            }
            center = new JPanel();
            center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
            center.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            /*
             * For each method in the class, add a new MethodPable to center
             */
            add(new JScrollPane(center), BorderLayout.CENTER);
            revalidate();
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
