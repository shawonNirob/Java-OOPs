package dataStructure;

import java.util.LinkedList;

public class WeightedGraph {
    public static class Edges {
        public int destination;
        public int weight;

        public Edges(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph {
        public int vertices;
        public LinkedList<Edges> adj[];

        public Graph(int vertices) {
            this.vertices = vertices;
            adj = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdges(int source, int destination, int weight) {
            Edges edges = new Edges(destination, weight);
            adj[source].add(edges);
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edges> list = adj[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex " + i + " is connected to " + adj[i].get(j).destination + " with weight " + adj[i].get(j).weight);
                }
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph.Graph graph = new WeightedGraph.Graph(6);

        graph.addEdges(0,1,4);
        graph.addEdges(0,2,3);
        graph.addEdges(1,2,5);
        graph.addEdges(1,3,2);
        graph.addEdges(2,3,1);
        graph.addEdges(3,4,2);
        graph.addEdges(4,0,4);
        graph.addEdges(4,1,4);
        graph.addEdges(4,5,6);

        graph.printGraph();
    }
}