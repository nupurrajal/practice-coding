package com.practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,10);
        graph.addEdge(6,7);
        graph.addEdge(10,9);
        graph.addEdge(7,8);
        graph.addEdge(9,8);
        graph.addEdge(8,11);

        System.out.println(isCyclePresent(graph.v, graph.adjacencyList));
    }

    private static boolean isCyclePresent(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v+1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (checkForCycleInComponent(adj, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycleInComponent(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(i, -1));
        visited[i] = true;
        while (!queue.isEmpty()) {
            PairNode node = queue.poll();
            for (int curr : adj.get(node.first)) {
                if (!visited[curr]) {
                    queue.add(new PairNode(curr, node.first));
                    visited[curr] = true;
                } else if (node.second != curr) {
                    return true;
                }
            }
        }
        return false;
    }
}
