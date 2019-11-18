package graphlib.graph;

import graphlib.edge.DirectedEdge;
import graphlib.edge.Node;
import graphlib.edge.Edge;

public class DirectedGraph extends Graph {
    @Override
    public Edge createEdge(Node from, Node to) {
        return new DirectedEdge(from, to);
    }
}
