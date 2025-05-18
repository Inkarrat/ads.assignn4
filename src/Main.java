// Demonstrates usage of BFS, DFS, and Dijkstra search algorithms
// on a weighted graph using Vertex-based structure.
public class Main {
    public static void main(String[] args) {
        // Создание вершин
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        // Создание графа
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 10);
        graph.addEdge(c, e, 3);
        graph.addEdge(e, d, 4);

        // BFS
        System.out.println("Breadth First Search from A:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(a);
        for (Vertex<String> v : graph.getVertices()) {
            if (bfs.hasPathTo(v)) {
                System.out.print("Path to " + v + ": ");
                for (Vertex<String> step : bfs.pathTo(v)) {
                    System.out.print(step + " ");
                }
                System.out.println();
            }
        }

        // Dijkstra
        System.out.println("\nDijkstra Search from A:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(a);
        for (Vertex<String> v : graph.getVertices()) {
            if (dijkstra.hasPathTo(v)) {
                System.out.print("Path to " + v + ": ");
                for (Vertex<String> step : dijkstra.pathTo(v)) {
                    System.out.print(step + " ");
                }
                System.out.printf(" | Distance: %.1f\n", dijkstra.distanceTo(v));
            }
        }
    }
}
