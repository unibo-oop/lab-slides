package it.unibo.oop.lab05.ex5;

/**
 * A class used to enclose two objects.
 * 
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 * @param <X>
 *            type of the first {@link Object}
 * @param <Y>
 *            type of the second {@link Object}
 */
public class Pair<X, Y> {

    private final X first;
    private final Y second;

    /**
     * @param o1
     *            the first object
     * @param o2
     *            the second object
     */
    public Pair(final X o1, final Y o2) {
        this.first = o1;
        this.second = o2;
    }

    /**
     * @return the first object
     */
    public X getFirst() {
        return this.first;
    }

    /**
     * @return the second object
     */
    public Y getSecond() {
        return this.second;
    }

    /**
     * Returns a string representation of the pair.
     * 
     * @return a string representing this pair's state
     */
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

    /**
     * Returns the hashcode for this pair, calculated via
     * {@link it.unibo.oop.lab05.ex5.HashUtils#djb2int32}.
     * 
     * @return the hascode of this pair.
     */
    public int hashCode() {
        /*
         * DJB-2.
         */
        return HashUtils.djb2int32(first.hashCode(), second.hashCode());
    }

    /**
     * Compares this pair to the specified object. The result is true if and
     * only if the argument is not null and is a Pair object containing the same
     * pair of object.
     * 
     * @param obj the object to compare this pair against
     * 
     * @return true if the given pair is equal to this pair
     */
    public boolean equals(final Object obj) {
        if (obj instanceof Pair) {
            final Pair<?, ?> p = (Pair<?, ?>) obj;
            if (first == null) {
                if (p.first != null) {
                    return false;
                }
            }
            if (second == null) {
                if (p.second != null) {
                    return false;
                }
            }
            return first.equals(p.first) && second.equals(p.second);
        }
        return false;
    }

}
