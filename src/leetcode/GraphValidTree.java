package leetcode;

import java.util.*;

import java.util.*;

import java.util.*;

class GraphValidTree{
    public boolean validTree(int n, int[][] edges) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Initialize an array to track visited nodes
        boolean[] visited = new boolean[n];

        // Check if a cycle exists in the graph
        if (hasCycle(adjacencyList, visited, 0, -1)) {
            return false;
        }

        // Check if all nodes are connected
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjacencyList, boolean[] visited, int node, int parent) {
        visited[node] = true;

        // Traverse the neighbors of the current node
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(adjacencyList, visited, neighbor, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is already visited and not the parent of the current node, a cycle exists
                return true;
            }
        }

        return false;
    }
}

