// Represents a weighted directed graph using Vertex objects.
// Allows adding edges with weights and retrieving all vertices.
import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices = new HashSet<>();

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        vertices.add(source);
        vertices.add(destination);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
