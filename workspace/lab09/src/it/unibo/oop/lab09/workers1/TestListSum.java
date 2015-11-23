package it.unibo.oop.lab09.workers1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * 
 * TestMatrix for worker 1.
 * 
 * @author mviroli
 * @author mcasadei
 *
 */
public class TestListSum {

    /*
     * Si fornisce l'interfaccia ISumList, con un metodo per calcolare la somma
     * degli elementi di una lista. Realizzare una classe MultiThreadedListSum,
     * con costruttore che accetta un intero positivo 'n', che implementa tale
     * funzionalità in modo "multi-threaded", con 'n' Worker che si dividono il
     * compito in modo sufficientemente omogeneo -- non è necessario che
     * l'ammontare dei compiti dei singoli Worker siano esattamente equivalenti.
     * Si faccia stampare (su System.out) ad ogni Worker una indicazione di che
     * porzione del lavoro svolge.
     * 
     * All'esecuzione del test qui sotto, le chiamate dovranno dare lo
     * stesso output, ad eccezione ovviamente dei tempi.
     */

    private static final int SIZE = 10000000;

    /**
     * Base test for a multithreaded list sum.
     */
    @Test
    public void testBasic() {
        List<Integer> list = new ArrayList<>(SIZE);
        long sum = 0;
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
            sum += i;
        }
        System.out.println("BTW: the sum with " + SIZE + " elements is: " + sum);
        long time;

        ISumList sumList = new MultiThreadedListSum(1);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 1 thread: " + (System.currentTimeMillis() - time) + " msec");
        
        sumList = new MultiThreadedListSum(3);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 3 threads: " + (System.currentTimeMillis() - time) + " msec");
        
        sumList = new MultiThreadedListSum(7);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 7 threads: " + (System.currentTimeMillis() - time) + " msec");
        
        sumList = new MultiThreadedListSum(10);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 10 threads: " + (System.currentTimeMillis() - time) + " msec");
        
        sumList = new MultiThreadedListSum(17);
        time = System.currentTimeMillis();
        assertEquals(sumList.sum(list), sum);
        System.out.println("Tried with 17 threads: " + (System.currentTimeMillis() - time) + " msec");
    }

}
