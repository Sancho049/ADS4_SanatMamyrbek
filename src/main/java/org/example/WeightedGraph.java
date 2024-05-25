package org.example;

import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> adjacencyMap = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        dest.addAdjacentVertex(source, weight);
        adjacencyMap.get(source).add(new Edge<>(source, dest, weight));
        adjacencyMap.get(dest).add(new Edge<>(dest, source, weight));
    }

    public List<Edge<Vertex<V>>> getEdges(Vertex<V> vertex) {
        return adjacencyMap.get(vertex);
    }

    public Set<Vertex<V>> getVertices() {
        return adjacencyMap.keySet();
    }
}
