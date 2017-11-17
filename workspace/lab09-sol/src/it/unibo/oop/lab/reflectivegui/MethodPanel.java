package it.unibo.oop.lab.reflectivegui;

import java.awt.Font;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Graphical representation of a method.
 */
public class MethodPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * @param m
     *            the method
     */
    public MethodPanel(final Method m) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final boolean isStatic = Modifier.isStatic(Objects.requireNonNull(m).getModifiers());
        final String methodSignature = (isStatic ? "static " : "")
            + m.getReturnType().getSimpleName() + ' '
            + m.getName() + '('
            + Stream.of(m.getParameterTypes())
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", ")) + ')';
        final JLabel methodLabel = new JLabel(methodSignature);
        if (isStatic) {
            methodLabel.setFont(methodLabel.getFont().deriveFont(Font.ITALIC));
        }
        super.add(methodLabel);
        if (isStatic && m.getParameterCount() == 0) {
            final JButton invoke = new JButton("Invoke");
            invoke.addActionListener(e -> {
                try {
                    JOptionPane.showMessageDialog(this, m.invoke(null), "Invocation result", JOptionPane.PLAIN_MESSAGE);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                    JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            });
            super.add(invoke);
        }
    }

}
