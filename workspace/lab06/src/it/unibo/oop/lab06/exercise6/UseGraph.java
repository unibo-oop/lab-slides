package it.unibo.oop.lab06.exercise6;

/**
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        final Graph<String> g = null; // new GraphImpl<>();

        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");

        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("c", "a");

        System.out.println(g.nodeSet()); // prints ["a","b","c","d","e"].. in
                                         // any order
        System.out.println(g.linkedNodes("c")); // prints ["d","a"].. in any
                                                // order
        System.out.println(g.getPath("b", "a")); // prints either the path b,c,a
                                                 // or b,c,d,e,a

    }
}
