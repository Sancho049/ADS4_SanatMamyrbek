package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);


        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v3, v4, 1);
        graph.addEdge(v4, v5, 5);
        graph.addEdge(v1, v5, 5);




        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS starting from vertex A:");
        bfs.bfs(v1);
        bfs.shortestPathBFS(v1,v4);
        // Call the method to find the shortest path
        List<Vertex<String >> shortestPath = bfs.shortestPathBFS(v1, v4);

// Check if a shortest path was found
        if (shortestPath != null) {
            System.out.println("Shortest Path:");
            for (Vertex<String> vertex : shortestPath) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("End");
        } else {
            System.out.println("No path found.");
        }



        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph.getVertices());
        System.out.println("\nDijkstra's shortest path from vertex A:");
        Map<Vertex<String>, Double> distances = dijkstra.dijkstra(v1, graph.getVertices());
        distances.forEach((vertex, distance) -> System.out.println(vertex + " : " + distance));
        // Вызываем метод для нахождения кратчайшего пути
        List<Vertex<String>> shortestPath2 = dijkstra.shortestPathDijkstra(v1, v4,graph);

        if (shortestPath2 != null) {
            // Выводим кратчайший путь
            System.out.println("Shortest Path:");
            for (Vertex<String> vertex : shortestPath2) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("End");
        } else {
            // Если путь не найден
            System.out.println("No path found.");
        }

    }
}
