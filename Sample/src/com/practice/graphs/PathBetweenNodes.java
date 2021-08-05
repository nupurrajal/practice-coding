package com.practice.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PathBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,5);
        graph.addEdge(4,6);

        System.out.println(areConnected(graph, 1, 3));
    }

    private static boolean areConnected(Graph graph, int u, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        boolean[] visited = new boolean[graph.v+1];
        visited[u] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int curr : graph.adjacencyList.get(node)) {
                if (!visited[curr]) {
                    if (curr == v) {
                        return true;
                    }
                    visited[curr] = true;
                    queue.offer(curr);
                }
            }
        }
        return false;
    }
}
