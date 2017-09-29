package it.unibo.oop.lab.workers01;

import java.util.List;

/**
 * 
 * An interface defining a method to sum up the elements of a list.
 *
 */
public interface SumList {

    /**
     * @param list
     *            an arbitrary-sized list of integers
     * @return the sum of its elements
     */
    long sum(List<Integer> list);

}
