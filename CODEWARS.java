import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
public class CODEWARS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        graph.addEdges(v0, v1, v0, v2, v0, v3, v1, v3, v3, v4);
        graph.addVertex(v5);
        boolean isConnected = CODEWARS.isConnected(graph);
        System.out.println("Is the graph connected? " + isConnected);
    }
    public static boolean isConnected(Graph graph) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        if (!graph.getVertices().isEmpty()) {
            Vertex startVertex = graph.getVertices().iterator().next();
            queue.add(startVertex);
            visited.add(startVertex);
        }
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            Set<Vertex> neighbors = getNeighbors(graph, currentVertex);

            for (Vertex neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited.size() == graph.getVertices().size();
    }
    private static Set<Vertex> getNeighbors(Graph graph, Vertex vertex) {
        Set<Vertex> neighbors = new HashSet<>();
        for (Edge edge : graph.getEdges()) {
            if (edge.getV1().equals(vertex)) {
                neighbors.add(edge.getV2());
            } else if (edge.getV2().equals(vertex)) {
                neighbors.add(edge.getV1());
            }
        }
        return neighbors;
    }
}