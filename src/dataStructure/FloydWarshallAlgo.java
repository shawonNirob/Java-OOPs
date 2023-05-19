package dataStructure;

import java.util.*;

public class FloydWarshallAlgo{
    public static class Edges{
        public int source;
        public int destination;
        public int weight;

        public Edges(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph{
        public int vertices;
        public List<Edges> adj;

        public Graph(int vertices){
            this.vertices = vertices;
            adj= new ArrayList<>();
        }

        public void addEdges(int source, int destination, int weight){
            Edges edge = new Edges(source, destination, weight);
            adj.add(edge);

            //// For an undirected graph, add the reverse edge as well
            //edges = new Edges(source, weight);
            //adj[destination].add(edges);
        }
    }

    public void printGraph(List<Edges> adj){
        for(Edges edge : adj){
            System.out.println(edge.source+" Connected with "+edge.destination + " with weight "+ edge.weight);
        }
    }

    public int[][] floydWarshall(int V, List<Edges> adj, int start){
        int[][] distance = new int[V][V];

        for(int i=start; i<V;i++){
            for(int j=start; j<V; j++){
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for(Edges edge : adj){
            distance[edge.source][edge.destination] = edge.weight;
         }

        for(int k=start; k<V; k++){
            for(int i=start; i<V;i++){
                for(int j=start; j<V; j++){
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                    if(i==j && distance[i][j] < 0){
                        //negative cycle detected
                        System.out.println("Negative cycle detected!");
                        return null;
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args){
        Graph graph = new Graph(4);

        graph.addEdges(1,2,3);
        graph.addEdges(2,1,8);
        graph.addEdges(2,3,2);
        graph.addEdges(3,4,1);
        graph.addEdges(3,1,-6);
        graph.addEdges(1,4,7);
        graph.addEdges(4,1,2);

        FloydWarshallAlgo algo = new FloydWarshallAlgo();

        algo.printGraph(graph.adj);
        System.out.println();


        int[][] distance = algo.floydWarshall(5, graph.adj, 1);

        for(int i=1; i<distance.length;i++){
            for(int j=1; j<distance[0].length; j++){
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
