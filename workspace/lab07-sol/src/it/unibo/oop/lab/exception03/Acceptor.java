package it.unibo.oop.lab.exception03;

/**
 * 
 * Represent the dual of an Iterator: accept elements in the same sequence as
 * configured on its Acceptable.
 *
 * @param <T>
 */
public interface Acceptor<T> {

    /**
     * Accept a new element. In case the element is not part of the set
     * sequence, returns a
     * {@link it.unibo.oop.lab.exception03.Acceptor.ElementNotAcceptedException}
     * .
     * 
     * @param newElement
     *            the next element to be accepted
     * @throws ElementNotAcceptedException
     *             if the element is out of the scheduled sequence
     */
    void accept(T newElement) throws ElementNotAcceptedException;

    /**
     * Terminate to input new elements. If more elements have still to be
     * inserted, throws an
     * {@link it.unibo.oop.lab.exception03.Acceptor.EndNotAcceptedException}.
     * 
     * @throws EndNotAcceptedException
     *             if more elements still need to be accepted
     */
    void end() throws EndNotAcceptedException;

    /*
     * Note: this class is public and static by default, so the modifiers are
     * not redundantly written here.
     */
    /**
     * Represents an exception occurring when trying to make the acceptor accept
     * a wrong (out-of-sequence) element.
     *
     */
    class ElementNotAcceptedException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = -3064859728330027691L;
        private final Object element;

        /**
         * 
         * @param element
         *            the element that cause the exception to be raised
         */
        public ElementNotAcceptedException(final Object element) {
            super();
            this.element = element;
        }

        /**
         * 
         * @return the elements that caused this exception to be raised
         */
        public Object getElement() {
            return element;
        }

    }

    /**
     * Occurring when trying to terminate accepting new elements, but still
     * other elements have to accepted.
     *
     */
    class EndNotAcceptedException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = -9112482421243100402L;
    }

}
