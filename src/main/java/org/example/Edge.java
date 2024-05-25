package org.example;

public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private double weight;

    public Edge(Vertex source, Vertex dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex dest) {
        this.source = source;
        this.dest = dest;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getDest() {
        return dest;
    }

    public Vertex getSource() {
        return source;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
