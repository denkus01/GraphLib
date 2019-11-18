package graphlib.graph;

import graphlib.edge.Edge;
import graphlib.edge.Node;
import graphlib.edge.UndirectedEdge;

public class UndirectedGraph extends Graph {
    @Override
    public Edge createEdge(Node from, Node to) {
        return new UndirectedEdge(from, to);
    }
}
