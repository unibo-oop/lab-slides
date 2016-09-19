package it.unibo.oop.lab07.exercise05;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This is the JUnit test for {@link it.unibo.oop.lab07.exercise05.Acceptable}
 * implementation.
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
            final List<Integer> list = Arrays.asList(10, 20, 30, 40);
            // the following has to be instantiated
            final Acceptable<Integer> acc = null;
            final Acceptor<Integer> acceptor = acc.acceptor();
            for (final Integer el: list) {
                acceptor.accept(el);
            }
            acceptor.end();
        } catch (Exception e) {
            fail("Sequence was supposed to be correct!");
        }
    }

    /**
     * Test if a wrong sequence makes an exception to be raised.
     * 
     */
    @Test
    public void test2() {
        // eccezione per via di un elemento accetatto in più
        final List<Integer> list = Arrays.asList(10, 20, 30, 40);
        // the following has to be instantiated
        final Acceptable<Integer> acc = null;
        final Acceptor<Integer> acceptor = acc.acceptor();
        try {
            for (final Integer el: list) {
                acceptor.accept(el);
            }
        } catch (Acceptor.ElementNotAcceptedException e) {
            // test failed: sequence is not accepted
            fail("Element out of sequence: " + e.getElement());
        }
        try {
            // makes an exception to be raised;
            acceptor.accept(-1);
            // assert: impossible to get here with a wrong element
            fail("Element out of sequence");
        } catch (Acceptor.ElementNotAcceptedException e) {
            // true because test has succeed: 50 not accepted
            assertNotNull(e);
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
        final List<Integer> list = Arrays.asList(10, 20, 30, 40);
        // the following has to be instantiated
        final Acceptable<Integer> acc = null;
        final Acceptor<Integer> acceptor = acc.acceptor();
        try {
            acceptor.accept(10);
        } catch (Acceptor.ElementNotAcceptedException e) {
            fail("No element expected: " + e.getElement());
        }
        try {
            acceptor.end();
            fail("More elements were expected!");
        } catch (Acceptor.EndNotAcceptedException e) {
            assertNotNull(e);
        }
    }

}
