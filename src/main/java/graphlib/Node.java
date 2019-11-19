package graphlib;

import graphlib.edge.Edge;
import java.util.HashSet;
import java.util.Set;
/**
 The class implements a graph node, with values referencing neighbors in the graph.
  */
public class Node<T> {
    private T value;
    private Set<Edge> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<Edge>();
    }

    public T getValue() {
        return value;
    }

    public void connect(Edge neighbour) {
        neighbors.add(neighbour);
    }

    public Set<Edge> getNeighbors() {
        return this.neighbors;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;
        if (obj == this) return true;
        Node node = (Node) obj;
        return (this.value != null && this.value.equals(node.value));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
