package it.unibo.oop.lab.mvc.view;

/**
 * Interface.
 */
public interface CounterView {

    /**
     * Called when a new count is initialized.
     */
    void init();

    /**
     * @param value
     *            the value of the counter
     */
    void update(int value);

    /**
     * Called when a count is terminated.
     */
    void terminate();

}
