package graphimplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyMatrixGraph<V> implements Graph<V>{
    protected List<V> vertices = new ArrayList<>(); // Store vertices
    protected List<Edge> edges = new ArrayList<>(); // Store edges
    protected int[][] matrix = new int[5][5];

    /** Construct an empty graph */
    public AdjacencyMatrixGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    @Override /** Return the number of vertices in the graph */
    public int getSize() {
        return vertices.size();
    }
    @Override /** Return the number of edges in the graph */
    public int getNumEdges() {
        return edges.size()/2;
    }
    @Override /** Return the vertices in the graph */
    public List<V> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    /** Return the edges in the graph */
    public List<Edge> getEdges() {
        return new ArrayList<Edge>(edges);
    }
    @Override /** Return the object for the specified vertex */
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override /** Return the index for the specified vertex object */
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override /** Return the neighbors of the specified vertex */
    public List<V> getNeighbors(V v) {
        int index = getIndex(v);
        Set<V> result = new HashSet<>();
        for (Edge e: edges){
            if (e.u == index){
                result.add(vertices.get(e.v));
            }else if(e.v== index){
                result.add(vertices.get(e.u));
            }
        }
        return new ArrayList<V>(result);
    }

    public List<Integer> getNeighborsIndex(V v) {
        int index = getIndex(v);
        Set<Integer> result = new HashSet<>();
        for (Edge e: edges){
            if (e.u == index){
                result.add(e.v);
            }else if(e.v== index){
                result.add(e.u);
            }
        }
        return new ArrayList<>(result);
    }

    @Override /** Return the incident edges of vertex v */
    public List<Edge> getIncidentEdges(V v){
        int index = getIndex(v);
        Set<Edge> result = new HashSet<>();
        for (Edge e: edges){
            if (e.u == index){
                result.add(e);
            }else if(e.v== index){
                result.add(e);
            }
        }
        return new ArrayList<>(result);
    }

    @Override /** Return the degree for a specified vertex */
    public int getDegree(V v) {
        return getNeighbors(v).size();
    }

    @Override /** Print the edges */
    public void printEdges() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(" (" +edges.get(i).u  + "," + edges.get(i).v +") :" + edges.get(i).element());
        }
    }

    @Override /** Clear the graph */
    public void clear() {
        vertices.clear();
        edges.clear();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    @Override /** Add a vertex to the graph */
    public boolean addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            return true;
        }
        else {
            return false;
        }
    }

    // @Override /** Add an edge to the graph */
    private boolean addEdge(Edge e) {
        if (e.u < 0 || e.u > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.u);

        if (e.v < 0 || e.v > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.v);

        if (!edges.contains(e)) {
            edges.add(e);
            return true;
        }
        else {
            return false;
        }
    }

    @Override /** Add an edge to the graph */
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u, v, 0)) && addEdge(new Edge(v, u, 0)) ;
    }
    @Override /** Add an edge to the graph */
    public boolean addEdge(int u, int v, int e) {
        boolean added = addEdge(new Edge(u, v, e))&& addEdge(new Edge(v, u, e));
        if (added) {
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        return added;
    }

    @Override /** Remove vertex v and return true if successful */
    public boolean remove(V v) {
        List<Edge> incidentEdges = getIncidentEdges(v);
        for (Edge e : incidentEdges) {
            remove(e.u, e.v);
        }
        int index = getIndex(v);
        boolean removed = vertices.remove(v);
        for (Edge e : edges) {
            if (e.v > index) {
                e.decreaseVertex(e.v);
            }
            if (e.u > index) {
                e.decreaseVertex(e.u);
            }
        }
        return removed;
    }

    @Override /** Remove edge (u, v) and return true if successful */
    public boolean remove(int u, int v) {
        boolean removed = false;
        for (Edge e : getEdges()) { // find the edges and remove both
            if ((e.u == u && e.v == v) || e.u == v && e.v == u) {
                edges.remove(e);
                removed = true;
            }
        }
        if (removed) {
            matrix[u][v] = 0;
            matrix[v][u] = 0;
        }
        return removed;
    }

    public void printMatrix() { // Jeg huggede den her fra GPT
        System.out.print("  ");
        for (int col = 0; col < matrix[0].length; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            // Print row index
            System.out.print(row + " ");
            // Print elements in the row
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
