package it.unibo.oop.lab07.exercise03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Utility class for cloning objects via reflection.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public final class ObjectClonerUtil {

    private static final String GETTER_PREFIX = "get";
    private static final String SETTER_PREFIX = "set";

    private ObjectClonerUtil() {

    }

    /**
     * Clone the object provided in input.
     * 
     * @param obj
     *            the object to clone
     * @param theClass
     *            using to apply reflection
     * @return the cloned object
     * @throws CloningException
     *             in case of any problem during the cloning
     * 
     * @param <T>
     *            the class to use to clone the object
     */
    public static <T> T cloneObj(final T obj, final Class<T> theClass) throws CloningException {
        T returnValue = null;
        try {
            final Constructor<T> c = theClass.getConstructor();
            returnValue = c.newInstance();
            final Method[] methods = theClass.getMethods();
            Method correspondingSetter;
            for (final Method m : methods) {
                if (m.getName().startsWith(GETTER_PREFIX) && m.getDeclaringClass().equals(theClass)) {
                    final Object res = m.invoke(obj);
                    correspondingSetter = theClass.getMethod(SETTER_PREFIX.concat(m.getName().substring(GETTER_PREFIX.length())),
                            m.getReturnType());
                    correspondingSetter.invoke(returnValue, res);
                }
            }
        } catch (Exception e) {
            throw new CloningException(e.toString());
        }
        return returnValue;
    }
}