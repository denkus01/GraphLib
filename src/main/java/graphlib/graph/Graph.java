package graphlib.graph;

import graphlib.edge.Edge;
import graphlib.edge.Node;
import graphlib.exception.GraphException;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    private final Set<Edge> edges;
    private final Map<Node, Node> nodes;

    Graph() {
        this.edges = new HashSet<>();
        this.nodes = new HashMap<>();
    }

    public void addNode(Node node) {
        if (!nodes.containsKey(node))
            this.nodes.put(node, node);
    }

    public void addEdge(Node from, Node to) {
        addNode(from);
        addNode(to);

        Edge edge = createEdge(nodes.get(from), nodes.get(to));

        if (!edges.contains(edge)) {
            this.edges.add(edge);
        } else {
            throw new IllegalArgumentException("Duplicated edge: " + edge);
        }
    }

    public List getPath(Node start, Node finish) throws GraphException {
        LinkedList<Node> queue = new LinkedList<>();
        Map<Node, Edge> edgePath = new HashMap<>();
        Deque<Edge> deque = new ArrayDeque<>();

        if ((nodes.get(start)) == null || nodes.get(finish) == null)
            throw new GraphException("Node not found in graph");

        queue.push(start);
        edgePath.put(start, null);

        while (!queue.isEmpty()) {
            Node source = queue.pop();
            Collection<Edge> edges = source.getNeighbors();

            for (Edge edge : edges) {
                Node target = edge.getTarget(source);

                if (finish.equals(target)) {
                    Node current = edge.getSource(finish);
                    deque.push(edge);
                    Edge pathItem;

                    while ((pathItem = edgePath.get(current)) != null) {
                        deque.addFirst(pathItem);
                        current = pathItem.getSource(current);
                    }
                    return new LinkedList<>(deque);
                }
                if (target != null && !edgePath.containsKey(target)) {
                    edgePath.put(target, edge);
                    queue.push(target);
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public abstract Edge createEdge(Node from, Node to);
}
