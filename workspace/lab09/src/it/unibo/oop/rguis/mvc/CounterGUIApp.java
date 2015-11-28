package it.unibo.oop.rguis.mvc;

import it.unibo.oop.rguis.mvc.controller.Controller;
import it.unibo.oop.rguis.mvc.model.CounterImpl;
import it.unibo.oop.rguis.mvc.model.CounterModel;
import it.unibo.oop.rguis.mvc.view.CounterGUI;
import it.unibo.oop.rguis.mvc.view.CounterView;

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
        final CounterModel model = new CounterImpl();
        final CounterView view = new CounterGUI();
        final Controller controller = new Controller(model, view);
        controller.start();
    }

}
