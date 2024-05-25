package org.example;

import java.util.*;

public class BreadthFirstSearch<V> {

    public void bfs(Vertex<V> start) {
        if (start == null) return;

        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        ArrayList<Vertex<V>> path = new ArrayList<>();
        Map<Vertex<V>,Vertex<V>> parentnode = new HashMap<>();

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
                Vertex<V> adjacentVertex = entry.getKey();
                if (!visited.contains(adjacentVertex)) {
                    queue.add(adjacentVertex);
                    visited.add(adjacentVertex);
                }
            }
        }

        System.out.println();
    }
    public List<Vertex<V>> shortestPathBFS(Vertex<V> startNode, Vertex<V> nodeToBeFound) {
        List<Vertex<V>> shortestPath = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visitedNodes = new HashSet<>();
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>(); // To track the parent of each visited node

        queue.add(startNode);
        visitedNodes.add(startNode);

        while (!queue.isEmpty()) {
            Vertex<V> currentNode = queue.poll();
            if (currentNode.equals(nodeToBeFound)) {
                // Reconstruct shortest path
                Vertex<V> node = nodeToBeFound;
                while (node != null) {
                    shortestPath.add(node);
                    node = parentMap.get(node);
                }
                Collections.reverse(shortestPath);
                return shortestPath;
            }

            Map<Vertex<V>, Double> unvisitedNodes = (Map<Vertex<V>, Double>) currentNode.getAdjacentVertices();
            for (Vertex<V> neighbor : unvisitedNodes.keySet()) {
                if (!visitedNodes.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedNodes.add(neighbor);
                    parentMap.put(neighbor, currentNode); // Set current node as parent of neighbor
                }
            }
        }
        return null;

    }

}
