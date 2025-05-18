// Performs Dijkstra's shortest path algorithm on a weighted graph.
import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();

    public DijkstraSearch(Vertex<V> start) {
        super(start);
        dijkstra(start);
    }

    private void dijkstra(Vertex<V> source) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));

        for (Vertex<V> v : getAllVertices(source)) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }

    private Set<Vertex<V>> getAllVertices(Vertex<V> start) {
        Set<Vertex<V>> all = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        all.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!all.contains(neighbor)) {
                    all.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return all;
    }
}
