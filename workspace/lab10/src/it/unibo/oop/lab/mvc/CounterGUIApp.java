package it.unibo.oop.lab.mvc;

import it.unibo.oop.lab.mvc.controller.ControllerImpl;
import it.unibo.oop.lab.mvc.controller.CounterController;
import it.unibo.oop.lab.mvc.model.Counter;
import it.unibo.oop.lab.mvc.model.CounterImpl;
import it.unibo.oop.lab.mvc.view.CounterGUI;
import it.unibo.oop.lab.mvc.view.CounterView;

/**
 * This is an example of reactive gui adopting a sample MVC implementation.
 *
 */
public final class CounterGUIApp {

    private CounterGUIApp() {
    }

    /**
     * 
     * @param args
     *            unused
     * 
     */
    public static void main(final String... args) {
        final Counter model = new CounterImpl();
        final CounterController controller = new ControllerImpl(model);
        final CounterGUI view = new CounterGUI(controller);
        final CounterView stdout = new CounterView() {
            @Override
            public void update(final int value) {
                System.out.println("Count is now " + value);
            }
            @Override
            public void terminate() {
                System.out.println("Count terminated.");
            }
            @Override
            public void init() {
                System.out.println("Count restarted.");
                update(0);
            }
        };
        controller.registerView(view);
        controller.registerView(stdout);
        view.setVisible(true);
    }

}
