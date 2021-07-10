package com.practice.graphs;

import java.util.ArrayList;

public class CycleDetectionDirectedDFS {
    public static void main(String[] args) {

        DirectedGraph directedGraph = new DirectedGraph(9);
        directedGraph.addEdge(1,2);
        directedGraph.addEdge(2,3);
        directedGraph.addEdge(3,4);
        directedGraph.addEdge(4,5);
        directedGraph.addEdge(3,6);
        directedGraph.addEdge(6,5);
        directedGraph.addEdge(7,2);
        directedGraph.addEdge(7,8);
        directedGraph.addEdge(8,9);
        directedGraph.addEdge(9,7);

        System.out.println(containsCycleInDirectedGraph(directedGraph.v, directedGraph.adjacencyList));
    }

    private static boolean containsCycleInDirectedGraph(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v+1];
        boolean[] dfsVisited = new boolean[v+1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (cycleCheck(i, adjacencyList, visited, dfsVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleCheck(int i, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, boolean[] dfsVisited) {
        visited[i] = true;
        dfsVisited[i] = true;
        for (int node : adjacencyList.get(i)) {
            if (!visited[node]) {
                if(cycleCheck(node, adjacencyList, visited, dfsVisited)) {
                    return true;
                }
            } else if (dfsVisited[node]) {
                return true;
            }
        }
        dfsVisited[i] = false;
        return false;
    }
}
