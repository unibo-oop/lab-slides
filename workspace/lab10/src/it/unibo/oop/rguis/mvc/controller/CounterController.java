package it.unibo.oop.rguis.mvc.controller;

import it.unibo.oop.rguis.mvc.view.CounterView;

/**
 * The interface of the controller, that can be used by any user interface
 * (textual, graphical...).
 * 
 * If the number of method explodes, a good idea could be to rely on the Command
 * pattern.
 */
public interface CounterController {

    /**
     * Starts counting when invoked.
     */
    void start();

    /**
     * Stops counting when invoked.
     */
    void stop();

    /**
     * Registers a new view to be controlled (pattern Observer).
     * 
     * @param view
     *            the view to register
     */
    void registerView(CounterView view);
}
