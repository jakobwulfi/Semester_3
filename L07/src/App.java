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

        List<Integer> verticesdfs = GraphAlgortihms.dfs(graph, vertices[0]);
        List<Integer> verticesbfs = GraphAlgortihms.bfs(graph, vertices[0]);
        System.out.println(verticesdfs);
        System.out.println(verticesbfs);
    }
}
