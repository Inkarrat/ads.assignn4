// Abstract base class for graph search algorithms.
import java.util.*;

public abstract class Search<V> {
    protected Vertex<V> start;
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    protected Set<Vertex<V>> visited = new HashSet<>();

    public Search(Vertex<V> start) {
        this.start = start;
    }

    public boolean hasPathTo(Vertex<V> v) {
        return visited.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
