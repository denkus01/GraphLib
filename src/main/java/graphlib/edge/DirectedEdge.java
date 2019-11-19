package graphlib.edge;

import graphlib.Node;

/**
 * Class for Direct Edges in a Graph
 * Have parameters such target  and source for get Node
 */
public class DirectedEdge extends Edge {
    public DirectedEdge(Node fromNode, Node toNode) {
        super(fromNode, toNode);
        fromNode.connect(this);
    }

    @Override
    public Node getTarget(Node source) {
        return source.equals(getFromNode()) ? getToNode() : null;
    }

    @Override
    public Node getSource(Node target) {
        return target.equals(getToNode()) ? getFromNode() : null;
    }
}
