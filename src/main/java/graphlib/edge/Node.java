package graphlib.edge;

import java.util.HashSet;
import java.util.Set;


public class Node<T> {
    private T value;
    private Set<Edge> neighbors = new HashSet<>();

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    void connect(Edge neighbour) {
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
        return value != null ?value.hashCode() :0;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
