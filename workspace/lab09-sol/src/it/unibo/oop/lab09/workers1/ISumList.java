package it.unibo.oop.lab09.workers1;

import java.util.List;

/**
 * 
 * An interface defining a method to sum up the elements of a list.
 * 
 * @author mviroli
 * @author mcasadei
 *
 */
public interface ISumList {

    /**
     * @param list
     *            an arbitrary-sized list of integers
     * @return the sum of its elements
     */
    long sum(List<Integer> list);

}
