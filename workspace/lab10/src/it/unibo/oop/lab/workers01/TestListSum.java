package it.unibo.oop.lab.workers01;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * 
 * TestMatrix for worker 1.
 *
 */
public class TestListSum {

    /**
     * SumList and its multithreaded implementation are given as reference
     * implementation of a software that sums the elements of a list.
     * 
     * Note that it is often impossible to split the load in an exact equal
     * manner - that's not an issue normally, however.
     */
    private static final int SIZE = 10000000;
    private static final String MSEC = " msec";

    /**
     * Base test for a multithreaded list sum.
     */
    @Test
    public void testBasic() {
        final List<Integer> list = IntStream
                .iterate(0, i -> i + 1)
                .limit(SIZE)
                .boxed()
                .collect(Collectors.toList());
        final long sum = list.stream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println("BTW: the sum with " + SIZE + " elements is: " + sum);

        long time;

        SumList sumList = new MultiThreadedListSum(1);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 1 thread: " + (System.currentTimeMillis() - time) + MSEC);

        sumList = new MultiThreadedListSum(3);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 3 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumList = new MultiThreadedListSum(8);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 8 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumList = new MultiThreadedListSum(10);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 10 threads: " + (System.currentTimeMillis() - time) + MSEC);

        sumList = new MultiThreadedListSum(16);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 16 threads: " + (System.currentTimeMillis() - time) + MSEC);
    }

}
