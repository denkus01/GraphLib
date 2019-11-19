package graphlib.graph;


import graphlib.Node;
import graphlib.exception.GraphException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class DirectedGraphTest {

    @Test
    public void shouldGetPathForDirectedGraph() throws GraphException {

        DirectedGraph directedGraph = new DirectedGraph();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);

        directedGraph.addEdge(one, two);
        directedGraph.addEdge(two, four);
        directedGraph.addEdge(four, seven);
        directedGraph.addEdge(four, six);
        directedGraph.addEdge(six, five);
        directedGraph.addEdge(five, three);
        directedGraph.addEdge(five, two);

        directedGraph.addNode(one);
        directedGraph.addNode(two);
        directedGraph.addNode(three);
        directedGraph.addNode(four);
        directedGraph.addNode(five);
        directedGraph.addNode(six);
        directedGraph.addNode(seven);

        List path = directedGraph.getPath(two, six);
        assertFalse(path.isEmpty());
    }
}