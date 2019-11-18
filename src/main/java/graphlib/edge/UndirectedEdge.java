package graphlib.edge;

public class UndirectedEdge extends Edge {
    public UndirectedEdge(Node fromNode, Node toNode) {
        super(fromNode, toNode);
        fromNode.connect(this);
        toNode.connect(this);
    }

    private boolean isLinked(Node node) {
        return node.equals(getFromNode()) || node.equals(getToNode());
    }

    @Override
    public Node getSource(Node target) {
        return getLinked(target);
    }

    @Override
    public Node getTarget(Node source) {
        return getLinked(source);
    }

    private Node getLinked(Node node) {
        if(isLinked(node)) {
            if (node.equals(getFromNode())) return getToNode();
            if (node.equals(getToNode())) return getFromNode();
        }
        return null;
    }
}
