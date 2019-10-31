/**
 * 
 */
package it.unibo.oop.jar.packages.pkg3;

import it.unibo.oop.jar.packages.pkg1.DummyClass;
import it.unibo.oop.jar.packages.pkg1.MinionDummy;
import it.unibo.oop.jar.packages.pkg2.EvenMoreDummy;
import it.unibo.oop.jar.packages.pkg2.MoreDummy;

/**
 * 
 */
public final class UseDummies {

    /*
     * Empty and private constructor: makes impossible to instance objects from
     * this class: it is a common pattern when writing utility classes (classes
     * containing only static methods). This way, it will be not possible to
     * write things such as: new UseDummies();
     */
    private UseDummies() {
    }

    /**
     * @param args
     *            unused.
     */
    public static void main(final String[] args) {
        final DummyClass[] dummies = { new DummyClass(), new MinionDummy(), new MoreDummy(), new EvenMoreDummy() };
        for (final DummyClass d : dummies) {
            System.out.println(d);
        }
    }

}
