package it.unibo.oop.lab07.exercise03;

/**
 * Utility class for cloning objects via reflection.
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
     * @param <T>
     *            the parametric class of the object to clone
     * @param obj
     *            the object to be cloned
     * @param theClass
     *            the class of the object to clone
     * @return the cloned object
     * @throws CloningException
     *             in case of any problem during the cloning
     */
    public static <T> T cloneObj(final T obj, final Class<T> theClass) throws CloningException {
        final T returnValue = null;
        /*
         * 1) Retrieve the constructor from theClass
         * 
         * 2) Cycle all the methods found in theClass
         * 
         * 3) If the method is a getter (starts with GETTER_PREFIX) of the
         * current class (i.e. is not a getter defined in a super class: use the
         * getDeclaringClass method for this check) find the corresponding
         * setter, keeping in mind that: - The setter name can be constructed by
         * a combination of:
         * 
         * 1)SETTER_PREFIX and
         * 
         * 2) a substring of the getter method name.
         * 
         * - The getReturnType method of the class Method returns the return
         *   type of a method
         * 
         * 4) Invoke the getter on obj and store the value in a temp var (tmp)
         * 
         * 5) Invoke the corresponding setter on returnValue providing parameter
         * tmp
         * 
         * 6) Return the cloned object
         */
        return returnValue;
    }
}