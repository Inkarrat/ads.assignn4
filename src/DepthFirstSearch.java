import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(Vertex<V> start) {
        super(start);
        dfs(start);
    }

    private void dfs(Vertex<V> current) {
        visited.add(current);
        for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
            if (!visited.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(neighbor);
            }
        }
    }
}
