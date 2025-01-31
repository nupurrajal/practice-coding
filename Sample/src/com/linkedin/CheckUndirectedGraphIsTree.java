package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class CheckUndirectedGraphIsTree {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Example graph (tree)
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);

        System.out.println(isTree(graph, V));
    }

    private static boolean isTree(List<List<Integer>> graph, int v) {
        int edges = 0;
        for (List<Integer> edge : graph) {
            edges += edge.size();
        }
        edges /= 2;
        if (edges != v-1) {
            return false;
        }
        boolean[] visited = new boolean[v];
        if (hasCycle(0, -1, visited, graph)) {
            return false;
        }

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(int i, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[i] = true;
        for (int curr : graph.get(i)) {
            if (!visited[curr]) {
                hasCycle(curr, i, visited, graph);
            } else {
                if (curr != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
