import java.util.*;

public abstract class GraphAlgortihms {
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        List<V> visitedVertices = new ArrayList<>();
        dfsHelp(graph, visitedVertices, v);
        return visitedVertices;
    }

    private static <V> void dfsHelp(Graph<V> graph, List<V> visitedVertices, V w) {
        visitedVertices.add(w);
        for (V vertex : graph.getNeighbors(w))
            if (!visitedVertices.contains(vertex)) {
                dfsHelp(graph, visitedVertices,vertex);
            }
    }
    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        List<V> visitedVertices = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        bfsHelp(graph, visitedVertices, queue, v);
        return visitedVertices;
    }
    private static <V> void bfsHelp(Graph<V> graph, List<V> visitedVertices, Queue<V> queue, V v) {
        visitedVertices.add(v);
        for (V vertex : graph.getNeighbors(v)) {
            if (!visitedVertices.contains(vertex)) {
                queue.add(vertex);
            }
        }
        while (!queue.isEmpty()) {
            V vertex = queue.poll();
            visitedVertices.add(vertex);
            for (V w : graph.getNeighbors(vertex)) {
                if (!visitedVertices.contains(w) && !queue.contains(w)) {
                    queue.add(w);
                }
            }
        }
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        ArrayList<V> vertices = (ArrayList<V>) graph.getVertices();
        ArrayList<V> verticesConnected = (ArrayList<V>) dfs(graph, vertices.get(0));
        if (vertices.size() == verticesConnected.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        ArrayList<V> vertices = (ArrayList<V>) graph.getVertices();
        return vertices.containsAll(List.of(v1, v2));
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge> mst(Graph<V> graph) {

        return null;
    }

}
