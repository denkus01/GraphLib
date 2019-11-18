package graphlib.edge;

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
