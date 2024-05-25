package org.example;

import org.example.Vertex;

class VertexDistance<V> {
    private Vertex<V> vertex;
    private double distance;

    public VertexDistance(Vertex<V> vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }
}