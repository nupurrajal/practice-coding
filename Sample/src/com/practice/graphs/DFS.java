package com.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,7);
        graph.addEdge(3,5);
        graph.addEdge(5,7);
        graph.addEdge(4,6);
        for (int i : dfs(0, graph)) {
            System.out.print(i + " ");
        }
    }


    private static List<Integer> dfs(int begin, Graph graph) {
        boolean[] visited = new boolean[graph.v + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= graph.v; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited, graph, result);
            }
        }
        return result;
    }

    private static void dfsUtil(int curr, boolean[] visited, Graph g, List<Integer> result) {
        visited[curr] = true;
        result.add(curr);
        for (int n : g.adjacencyList.get(curr)) {
            if (!visited[n]) {
                dfsUtil(n, visited, g, result);
            }
        }
    }
}
