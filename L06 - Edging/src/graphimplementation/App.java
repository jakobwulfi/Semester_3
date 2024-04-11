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
        //System.out.println(findTheGreatestVertex(graph));
        graph.printEdges();
        System.out.println();
        graph.remove(vertices[2]);
        graph.printEdges();
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
