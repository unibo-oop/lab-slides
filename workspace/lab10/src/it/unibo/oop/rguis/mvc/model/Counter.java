package it.unibo.oop.rguis.mvc.model;

/**
 * Defines the interface of a counter.
 *
 */
public interface Counter {

    /**
     * Increments the counter.
     */
    void increment();

    /**
     * Returns counter current value.
     * 
     * @return the current value
     */
    int getValue();
    
    void reset();

}
