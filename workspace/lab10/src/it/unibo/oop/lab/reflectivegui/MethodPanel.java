package it.unibo.oop.lab.reflectivegui;

import java.awt.Font;
import java.lang.reflect.Method;

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
        /*
         * Determine whether or not the method is static. Suggestion: use
         * Modifier.isStatic(int)
         * 
         */
        final boolean isStatic = true;
        /*
         * Compute the method signature as String:
         * 
         * [static] returnType methodName(arg0Type, arg1Type...)
         * 
         * - It must have a heading static keyword in case the method is static
         * 
         * - It must report the return type of the method
         * 
         * - It must report the method name
         * 
         * - Between parentheses, it should list the types expected by the method.
         * 
         * 
         * Example 1 -- java.lang.Math.random:
         * 
         * static double random();
         * 
         * 
         * Example 2 -- java.util.List.add
         * 
         * boolean add(Object)
         * 
         */
        final String methodSignature = "";
        final JLabel methodLabel = new JLabel(methodSignature);
        if (isStatic) {
            methodLabel.setFont(methodLabel.getFont().deriveFont(Font.ITALIC));
        }
        super.add(methodLabel);
        if (isStatic && m.getParameterCount() == 0) {
            final JButton invoke = new JButton("Invoke");
            invoke.addActionListener(e -> {
                /*
                 * Invoke the method, and display the result
                 */
                final Object invocationResult = null;
                JOptionPane.showMessageDialog(this, invocationResult, "Invocation result", JOptionPane.PLAIN_MESSAGE);
            });
            super.add(invoke);
        }
    }

}
