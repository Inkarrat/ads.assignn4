ADS Assignment 4
This repository contains implementations of graph traversal algorithms — Breadth-First Search (BFS) and Dijkstra's algorithm for weighted graphs — using Vertex-based representation instead of Edge objects.

Project Description
The project includes:

Vertex class representing graph nodes with necessary data (such as adjacency and weights).

Traversal classes:

BreadthFirstSearch — BFS implementation for graphs.

DijkstraSearch — Dijkstra’s algorithm for shortest paths in weighted graphs.

Abstract class Search — common interface and logic for traversal algorithms.

Graph representations:

WeightedGraph and UnweightedGraph.

Main class demonstrating how to use the implemented algorithms.

The key feature is working directly with vertices without a separate Edge class, which requires a custom approach to store and process path weights.

Notes
There is no Edge class; all graph logic is handled via vertices.

Data structures for adjacency and weights are maintained inside vertices.

This implementation is intended for educational purposes to understand graph traversal algorithms.
