// Performs a breadth-first search (BFS) on a graph.
import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> start) {
        super(start);
        bfs(start);
    }

    private void bfs(Vertex<V> current) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(current);
        queue.offer(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> neighbor : v.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
