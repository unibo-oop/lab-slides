/**
 * 
 */
package it.unibo.oop.lab06.exercise6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of a graph.
 * 
 * @author Danilo Pianini
 *
 * @param <N>
 *            node type
 */
public class GraphImpl<N> implements Graph<N> {

	private final Map<N, Set<N>> graph = new HashMap<>();

	@Override
	public void addNode(final N node) {
		graph.putIfAbsent(node, new HashSet<>());
	}

	@Override
	public void addEdge(final N source, final N target) {
		if (graph.containsKey(source) && graph.containsKey(target)) {
			graph.get(source).add(target);
		} else {
			System.out.println("WARNING: edge added between unexisting nodes (" + source + ", " + target + "). Edge will be ignored");
		}
	}

	@Override
	public Set<N> nodeSet() {
		return new HashSet<>(graph.keySet());
	}

	@Override
	public Set<N> linkedNodes(final N node) {
		return new HashSet<>(graph.get(node));
	}

	@Override
	public List<N> getPath(final N source, final N target) {
		if (graph.containsKey(source) && graph.containsKey(target)) {
			final List<N> startList = new ArrayList<>();
			startList.add(source);
			return buildPath(source, target, startList);
		}
		System.out.println("Cannot compute path between nodes which are not in the graph (" + source + ", " + target + "). Edge will be ignored");
		return Collections.emptyList();
	}

	private List<N> buildPath(final N source, final N target, final List<N> path) {
		if (source.equals(target)) {
			final List<N> res = new ArrayList<>();
			res.add(source);
			return res;
		}
		final Set<N> steps = graph.get(source);
		if (steps.contains(target)) {
			path.add(target);
			return path;
		}
		for (final N step : steps) {
			if (!path.contains(step)) {
				path.add(step);
				final List<N> possibleResult = buildPath(step, target, path);
				if (target.equals(possibleResult.get(possibleResult.size() - 1))) {
					return possibleResult;
				}
				path.remove(path.size() - 1);
			}
		}
		return Collections.emptyList();
	}

}
