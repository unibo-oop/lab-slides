package it.unibo.oop.lab.workers01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * TestMatrix for worker 1.
 *
 */
public class TestListSumClassic {

    /**
     * SumList and its multithreaded implementation are given as reference
     * implementation of a software that sums the elements of a list.
     * 
     * Note that it is often impossible to split the load in an exact equal
     * manner - that's not an issue normally, however.
     */
    private static final int SIZE = 10_000_000;
    private static final String MSEC = " msec";

    /**
     * Base test for a multithreaded list sum.
     */
    @Test
    public void testBasic() {
        /*
         * Initialize a list
         */
        final List<Integer> list = new ArrayList<>(SIZE);
        long sum = 0;
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
            sum += i;
        }
        System.out.println("BTW: the sum with " + SIZE + " elements is: " + sum);
        /*
         * Prepare time ant test with different number of threads
         */
        long time;
        for (final int threads: new int[] { 1, 2, 3, 8, 16, 32 }) {
            final SumList sumList = new MultiThreadedListSumClassic(threads);
            time = System.currentTimeMillis();
            assertEquals(sum, sumList.sum(list));
            System.out.println("Tried with " + threads + " thread: "
                    + (System.currentTimeMillis() - time) + MSEC);
        }
    }

}
