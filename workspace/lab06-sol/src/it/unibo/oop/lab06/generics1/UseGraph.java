package it.unibo.oop.lab06.generics1;

/**
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        final Graph<String> g = new GraphImpl<>();

        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addNode("f");
        g.addNode("g");
        g.addNode("h");
        g.addNode("i");
        g.addNode("j");

        g.addEdge("a", "b");
        g.addEdge("b", "d");
        g.addEdge("d", "c");
        g.addEdge("c", "e");
        g.addEdge("e", "d");
        g.addEdge("e", "f");
        g.addEdge("d", "f");
        g.addEdge("e", "g");
        g.addEdge("d", "j");
        g.addEdge("j", "i");
        g.addEdge("i", "f");
        g.addEdge("f", "g");
        g.addEdge("i", "h");
        g.addEdge("g", "h");

        System.out.println(g.nodeSet());
        // ["a","b","c","d","e"].. in any order
        System.out.println(g.linkedNodes("c"));
        // ["d","a"].. in any order
        System.out.println(g.getPath("a", "h"));
        // the path a,b,d,f,g,h or the path a,b,d,j,i,h or the path a,b,d,c,e,f,g,h or the path a,b,d,c,e,g,h

        // Try to change the search strategy in GraphImpl.getPath()
    }
}
