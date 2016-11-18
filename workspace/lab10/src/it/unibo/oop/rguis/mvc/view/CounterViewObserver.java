package it.unibo.oop.rguis.mvc.view;

/**
 * Define the interface of an observer "listening" for something to occur on the
 * view.
 *
 */
public interface CounterViewObserver {

    /**
     * Stops counting.
     */
    void stop();

}
