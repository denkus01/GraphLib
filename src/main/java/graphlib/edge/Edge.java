package graphlib.edge;

public abstract class Edge  {

    private Node fromNode;
    private Node toNode;

    public abstract Node getTarget(Node source);

    public abstract Node getSource(Node target);

    Edge(Node fromNode, Node toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    Node getFromNode() {
        return fromNode;
    }

    Node getToNode() {
        return toNode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Edge)) return false;

        Edge edge = (Edge) obj;
        return fromNode.equals(edge.fromNode) && toNode.equals(edge.toNode);

    }

    @Override
    public int hashCode() {
        int result = fromNode.hashCode();
        result = 31 * result + toNode.hashCode();
        return result;
    }
}
