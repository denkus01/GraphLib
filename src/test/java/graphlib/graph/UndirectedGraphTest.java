package graphlib.graph;

import graphlib.edge.Node;
import graphlib.exception.GraphException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    @Test
    void shouldGetPathForUndirectedGraph() throws GraphException {

        UndirectedGraph undirectedGraph = new UndirectedGraph();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);

        undirectedGraph.addEdge(one, two);
        undirectedGraph.addEdge(two, four);
        undirectedGraph.addEdge(four, seven);
        undirectedGraph.addEdge(four, six);
        undirectedGraph.addEdge(six, five);
        undirectedGraph.addEdge(five, three);
        undirectedGraph.addEdge(five, two);

        undirectedGraph.addNode(one);
        undirectedGraph.addNode(two);
        undirectedGraph.addNode(three);
        undirectedGraph.addNode(four);
        undirectedGraph.addNode(five);
        undirectedGraph.addNode(six);
        undirectedGraph.addNode(seven);

        List path = undirectedGraph.getPath(seven, two);
        assertFalse(path.isEmpty());
    }
}