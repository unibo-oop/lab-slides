package it.unibo.oop.lab.reflectivefactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Used to test reflection on ClonableClass.
 * 
 */
public class TestCloner {

    /**
     * Used to test reflection on a ClonableClass instance.
     * 
     */
    @Test
    public void testInstanceCloning() {
        // 1) Creare una istanza di ClonableClass
        final ClonableClass d = new ClonableClass();
        try {
            // 2) Invocare i vari setter per memorizzare dei valori nei campi
            d.setA("Test valore di a");
            d.setB("Test valore di b");
            d.setD(1.0);
            // 3) Clonare l'oggetto usando il metodo cloneObj di
            // ObjectClonerUtil
            final ClonableClass res = ObjectClonerUtil.cloneObj(d, ClonableClass.class);
            /*
             * 4) Stampare in stdout l'oggetto clonato e verificare se
             * l'operzione di cloning è stata effettuata correttamente.
             */
            assertEquals("A differs! ", d.getA(), res.getA());
            assertEquals("B differs! ", d.getB(), res.getB());
            assertEquals("D differs! ", d.getD(), res.getD());

        } catch (CloningException e) {
            fail();
        }
    }
}
