package it.unibo.oop.lab.mvc.model;

/**
 * Implementation of {@link Counter}}.
 *
 */
public class CounterImpl implements Counter {

    private int counter;

    /**
     * Constructs a new counter.
     */
    public CounterImpl() {
        counter = 0;
    }

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int getValue() {
        return counter;
    }

    @Override
    public void reset() {
        counter = 0;
    }

}
