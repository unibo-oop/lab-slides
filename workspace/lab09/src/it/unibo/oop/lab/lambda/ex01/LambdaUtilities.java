package it.unibo.oop.lab.lambda.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class will contain four utility functions on lists and maps, of which the first one is provided as exmaple.
 * 
 * All such methods take as second argument a functional interface from the Java library (java.util.function).
 * This enables calling them by using the concise lambda syntax, as it's done in the main function.
 * 
 * Realize the three methods **WITHOUT** using the Stream library, but only leveraging the lambdas.
 *
 */
public final class LambdaUtilities {

    private LambdaUtilities() {
    }

    /**
     * @param list
     *            the input list
     * @param op
     *            the process to run on each element
     * @param <T>
     *            element type
     * @return a new list containing, for each element of list, the element and
     *         a processed version
     */
    public static <T> List<T> dup(final List<T> list, final UnaryOperator<T> op) {
        final List<T> l = new ArrayList<>(list.size() * 2);
        list.forEach(t -> {
            l.add(t);
            l.add(op.apply(t));
        });
        return l;
    }

    /**
     * @param list
     *            input list
     * @param pre
     *            predicate to execute
     * @param <T>
     *            element type
     * @return a list where each value is an Optional, holding the previous
     *         value only if the predicate passes, and an Empty optional
     *         otherwise.
     */
    public static <T> List<Optional<T>> optFilter(final List<T> list, final Predicate<T> pre) {
        /*
         * Suggestion: consider Optional.filter
         */
        return null;
    }

    /**
     * @param list
     *            input list
     * @param op
     *            a function that, for each element, computes a key
     * @param <T>
     *            element type
     * @param <R>
     *            key type
     * @return a map that groups into categories each element of the input list,
     *         based on the mapping done by the function
     */
    public static <R, T> Map<R, Set<T>> group(final List<T> list, final Function<T, R> op) {
        /*
         * Suggestion: consider Map.merge
         */
        return null;
    }

    /**
     * @param map
     *            input map
     * @param def
     *            the supplier
     * @param <V>
     *            element type
     * @param <K>
     *            key type
     * @return a map whose non present values are filled with the value provided
     *         by the supplier
     */
    public static <K, V> Map<K, V> fill(final Map<K, Optional<V>> map, final Supplier<V> def) {
        /*
         * Suggestion: consider Optional.orElse
         * 
         * Keep in mind that a map can be iterated through its forEach method
         */
        return null;
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        final List<Integer> li = IntStream.range(1, 8).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
        System.out.println(dup(li, x -> x + 100));
        /*
         * [1, 101, 2, 102, 3, 103, 4, 104, 5, 105, 6, 106, 7, 107]
         */
        System.out.println(group(li, x -> x % 2 == 0 ? "even" : "odd"));
        /*
         * {odd=[1, 3, 5, 7], even=[2, 4, 6]}
         */
        final List<Optional<Integer>> opt = optFilter(li, x -> x % 3 == 0);
        System.out.println(opt);
        /*
         * [Optional.empty, Optional.empty, Optional[3], Optional.empty,
         * Optional.empty, Optional[6], Optional.empty]
         */
        final Map<Integer, Optional<Integer>> map = new HashMap<>();
        for (int i = 0; i < opt.size(); i++) {
            map.put(i, opt.get(i));
        }
        System.out.println(fill(map, () -> (int) (-Math.random() * 10)));
        /*
         * {0=-2, 1=-7, 2=3, 3=-3, 4=-7, 5=6, 6=-3}
         */
    }
}
