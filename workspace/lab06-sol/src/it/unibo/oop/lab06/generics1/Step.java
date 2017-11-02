package it.unibo.oop.lab06.generics1;

import java.util.List;
import java.util.LinkedList;

class Step<N> {
    private final Step<N> prevStep;
    private final N position;

    public Step(final N to) {
        this(null, to);
    }

    public Step(final Step<N> from, final N to) {
        this.prevStep = from;
        this.position = to;
    }

    public List<N> getPath() {
        final List<N> result = new LinkedList<>();
        Step<N> curr = this;
        do {
            result.add(0, curr.position);
            curr = curr.prevStep;
        } while (curr != null);
        return result;
    }

    public N getPosition() {
        return position;
    }

    @Override
    public String toString() {
        final List<String> elements = new LinkedList<>();
        for (final N node : getPath()) {
            elements.add(node.toString());
        }
        return String.join(" -> ", elements);
    }

}