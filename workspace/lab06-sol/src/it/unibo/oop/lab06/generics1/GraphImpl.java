package it.unibo.oop.lab06.generics1;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of {@link Graph} only storing explicitly defined arcs.
 * It is the ideal choice when handling poorly connected graphs.
 *
 * @param <N> the type of the nodes of the graph
 */
public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> edges = new HashMap<N, Set<N>>();

    @Override
    public void addEdge(final N source, final N target) {
        if (ensureNodesExist(source, target)) {
            final Set<N> sourceOutgoingEdges = edges.get(source);
            if (!sourceOutgoingEdges.contains(target)) {
                sourceOutgoingEdges.add(target);
            }
        }
    }

    @Override
    public void addNode(final N node) {
        edges.putIfAbsent(node, new HashSet<N>());
    }

    @SafeVarargs
    private final boolean ensureNodesExist(final N... nodes) {
        for (final N node : nodes) {
            if (!edges.containsKey(node)) {
                throw new IllegalArgumentException("No such a node: " + node);
            }
        }
        return true;
    }

    private int getNodesCount() {
        return edges.keySet().size();
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        if (ensureNodesExist(source, target)) {
            return graphSearch(source, target, SearchStrategies.BREADTH_FIRST);
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Implements a fringe-based, pluggable-strategy, uninformed search algorithm
     *
     * @see http://artint.info/html/ArtInt_51.html
     */
    private List<N> graphSearch(final N source, final N target, final SearchStrategies strategy) {
        final Deque<Step<N>> fringe = new LinkedList<>();
        fringe.add(new Step<>(source));
        final Set<N> alreadyVisited = new HashSet<>();
        while (!fringe.isEmpty() && alreadyVisited.size() < getNodesCount()) {
            final Step<N> lastStep = fringe.poll();
            final N currentNode = lastStep.getPosition();

            if (currentNode.equals(target)) {
                return lastStep.getPath();
            } else if (!alreadyVisited.contains(currentNode)) {
                alreadyVisited.add(currentNode);

                updateFringe(strategy, fringe, lastStep);
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        return edges.get(node);
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(edges.keySet());
    }

    private void updateFringe(final SearchStrategies strategy, final Deque<Step<N>> fringe, final Step<N> lastStep) {
        final N currentNode = lastStep.getPosition();
        switch (strategy) {
        case BREADTH_FIRST:
            for (final N reachableNode : linkedNodes(currentNode)) {
                fringe.addLast(new Step<>(lastStep, reachableNode));
            }
            break;
        case DEPTH_FIRST:
            for (final N reachableNode : linkedNodes(currentNode)) {
                fringe.addFirst(new Step<>(lastStep, reachableNode));
            }
            break;
        default:
            throw new IllegalStateException("There is a new strategy that has not been implemented yet: " + strategy);
        }
    }
}