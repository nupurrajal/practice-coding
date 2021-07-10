package com.practice.graphs;

import java.util.ArrayList;

public class CycleDetectionDFS {
    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(1,3);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(5,6);
        graph.addEdge(5,8);
        graph.addEdge(6,7);
//        graph.addEdge(8,7);

        System.out.println(isCyclePresent(graph.v, graph.adjacencyList));
    }

    private static boolean isCyclePresent(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v+1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (checkForCycleInComponent(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycleInComponent(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
        visited[i] = true;
        for (int curr : adj.get(i)) {
            if (!visited[curr]) {
                if (checkForCycleInComponent(adj, curr, visited, i))
                    return true;
            } else if (parent != curr) {
                return true;
            }
        }
        return false;
    }
}
