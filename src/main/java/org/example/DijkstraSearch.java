package org.example;

import java.util.*;

public class DijkstraSearch<V> {
    Set<Vertex<V>> allVertices = new HashSet<>();
    public DijkstraSearch(Set<Vertex<V>> allVertices) {
        this.allVertices = allVertices;
    }
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> start, Set<Vertex<V>> allVertices) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<VertexDistance<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> vertex : allVertices) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        priorityQueue.add(new VertexDistance<>(start, 0.0));

        while (!priorityQueue.isEmpty()) {
            VertexDistance<V> current = priorityQueue.poll();
            Vertex<V> currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) continue;
            visited.add(currentVertex);

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.get(currentVertex) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    priorityQueue.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }

        return distances;
    }
    public List<Vertex<V>> shortestPathDijkstra(Vertex<V> startNode, Vertex<V> endNode, WeightedGraph<V> graph) {
        Map<Vertex<V>, Double> distance = new HashMap<>();
        PriorityQueue<VertexDistance<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        // Initialize distances
        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(startNode)) {
                distance.put(vertex, 0.0);
            } else {
                distance.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        queue.add(new VertexDistance<>(startNode, 0.0));

        while (!queue.isEmpty()) {
            VertexDistance<V> current = queue.poll();
            Vertex<V> currentVertex = current.getVertex();

            // If we reached the endNode, reconstruct and return the path
            if (currentVertex.equals(endNode)) {
                List<Vertex<V>> path = new ArrayList<>();
                while (previous.containsKey(currentVertex)) {
                    path.add(currentVertex);
                    currentVertex = previous.get(currentVertex);
                }
                path.add(startNode);
                Collections.reverse(path);
                return path;
            }

            // Update distances for adjacent vertices
            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distance.get(currentVertex) + weight;

                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    previous.put(neighbor, currentVertex);
                    queue.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }

        // If endNode is unreachable, return null
        return null;
    }

}


