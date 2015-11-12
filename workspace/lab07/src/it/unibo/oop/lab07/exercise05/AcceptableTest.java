package it.unibo.oop.lab07.exercise05;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This is the JUnit test for {@link it.unibo.oop.lab07.exercise05.Acceptable}
 * implementation.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public class AcceptableTest {

    /**
     * This is a first acceptance test.
     */
    @Test
    public void test1() {
        // test di una accettazione corretta:
        // accettazione della lista 10, 20, 30, 40
        try {
            List<Integer> list = Arrays.asList(10, 20, 30, 40);
            // the following has to be instantiated
            Acceptable<Integer> acc = null;
            Acceptor<Integer> acceptor = acc.acceptor();
            acceptor.accept(10);
            acceptor.accept(20);
            acceptor.accept(30);
            acceptor.accept(40);
            acceptor.end();
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test if a wrong sequence makes an exception to be raised.
     * 
     */
    @Test
    public void test2() {
        // eccezione per via di un elemento accetatto in più
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        // the following has to be instantiated
        Acceptable<Integer> acc = null;
        Acceptor<Integer> acceptor = acc.acceptor();
        try {
            acceptor.accept(10);
            acceptor.accept(20);
            acceptor.accept(30);
            acceptor.accept(40);
            assertTrue(true);
        } catch (Acceptor.ElementNotAcceptedException e) {
            // test failed: sequence is not accepted
            fail();
        }
        try {
            // makes an exception to be raised;
            acceptor.accept(50);
            // assert: impossible to get here with a wrong element
            fail();
        } catch (Acceptor.ElementNotAcceptedException e) {
            // true because test has succeed: 50 not accepted
            assertTrue(true);
        }
    }

    /**
     * Test raising
     * {@link it.unibo.oop.lab07.exercise05.Acceptor.EndNotAcceptedException}.
     * 
     */
    @Test
    public void test3() {
        // eccezione per via di una fine anticipata
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        // the following has to be instantiated
        Acceptable<Integer> acc = null;
        Acceptor<Integer> acceptor = acc.acceptor();
        try {
            acceptor.accept(10);
            acceptor.accept(20);
            assertTrue(true);
        } catch (Acceptor.ElementNotAcceptedException e) {
            assertTrue("No element expected: " + e.getElement(), false);
        }
        try {
            acceptor.end();
            fail();
        } catch (Acceptor.EndNotAcceptedException e) {
            assertTrue(true);
        }
    }

}
