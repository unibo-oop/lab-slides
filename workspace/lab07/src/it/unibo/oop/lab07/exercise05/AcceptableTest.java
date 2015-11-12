package it.unibo.oop.lab07.exercise05;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//FIXME please fix magic numbers spread in the code
/**
 * This is the JUnit test for {@link Acceptable}
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
            final List<Integer> list = Arrays.asList(10, 20, 30, 40);
            // TODO the following has to be instantiated
            final Acceptable<Integer> acc = null;
            final Acceptor<Integer> acceptor = acc.acceptor();
            acceptor.accept(10);
            acceptor.accept(20);
            acceptor.accept(30);
            acceptor.accept(40);
            acceptor.end();
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
        final List<Integer> list = Arrays.asList(10, 20, 30, 40);
        // TODO the following has to be instantiated
        final Acceptable<Integer> acc = null;
        final Acceptor<Integer> acceptor = acc.acceptor();
        try {
            acceptor.accept(10);
            acceptor.accept(20);
            acceptor.accept(30);
            acceptor.accept(40);
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
            System.out.println("50 cannot be accepted as a valid element");
        }
    }

    /**
     * Test raising
     * {@link Acceptor.EndNotAcceptedException}.
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
            acceptor.accept(20);
        } catch (Acceptor.ElementNotAcceptedException e) {
            fail("No element expected: " + e.getElement());
        }
        try {
            acceptor.end();
            fail();
        } catch (Acceptor.EndNotAcceptedException e) {
            System.out.println("Impossible to end the sequence");
        }
    }

}
