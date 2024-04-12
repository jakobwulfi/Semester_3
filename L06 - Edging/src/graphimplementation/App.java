package graphimplementation;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EdgeListGraph graph = new EdgeListGraph();
        int[] vertices = {123,66,38,6,4};
        for (int i = 0; i < vertices.length; i++) {
            graph.addVertex(vertices[i]);
        }
        graph.addEdge(0,1,76);
        graph.addEdge(0,2,55);
        graph.addEdge(0,3,7);
        graph.addEdge(1,2,2);
        graph.addEdge(1,4,90);
        graph.addEdge(1,3,8);
        graph.addEdge(2,4,10);
        graph.addEdge(3,4,23);
        System.out.println("GreatestVertex:");
        System.out.println(findTheGreatestVertex(graph));
        System.out.println("\nEdgeListGraph:");
        graph.printEdges();
        System.out.println();
        graph.remove(vertices[2]);
        graph.printEdges();
        System.out.println("\nAdjacencyEdgeListGraph:");
        AdjacencyEdgeListGraph adjacencyGraph = new AdjacencyEdgeListGraph<>();
        for (int i = 0; i < vertices.length; i++) {
            adjacencyGraph.addVertex(vertices[i]);
        }
        adjacencyGraph.addEdge(0,1,76);
        adjacencyGraph.addEdge(0,2,55);
        adjacencyGraph.addEdge(0,3,7);
        adjacencyGraph.addEdge(1,2,2);
        adjacencyGraph.addEdge(1,4,90);
        adjacencyGraph.addEdge(1,3,8);
        adjacencyGraph.addEdge(2,4,10);
        adjacencyGraph.addEdge(3,4,23);

        adjacencyGraph.printEdges();
        adjacencyGraph.remove(vertices[2]);
        System.out.println();
        adjacencyGraph.printEdges();

        System.out.println("\nMatrix graph:");
        AdjacencyMatrixGraph graph3 = new AdjacencyMatrixGraph<>();
        for (int i = 0; i < vertices.length; i++) {
            graph3.addVertex(vertices[i]);
        }
        graph3.addEdge(0,1,76);
        graph3.addEdge(0,2,55);
        graph3.addEdge(0,3,7);
        graph3.addEdge(1,2,2);
        graph3.addEdge(1,4,90);
        graph3.addEdge(1,3,8);
        graph3.addEdge(2,4,10);
        graph3.addEdge(3,4,23);

        graph3.printEdges();
        System.out.println();
        graph3.printMatrix();
        graph3.remove(vertices[2]);
        System.out.println();
        graph3.printEdges();
        System.out.println();
        graph3.printMatrix();
    }
    public static <V extends Comparable<V>> V findTheGreatestVertex(EdgeListGraph<V> graph) {
        List<V> vertices = graph.getVertices();
        if (graph.getSize() == 0) {
            throw new IllegalArgumentException("Empty graph.");
        }
        V greatestVertex = vertices.get(0);
        for (V vertex :vertices) {
            if (vertex.compareTo(greatestVertex) > 0) {
                greatestVertex = vertex;
            }
        }
        return greatestVertex;
    }
}
