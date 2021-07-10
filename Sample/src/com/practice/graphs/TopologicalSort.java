package com.practice.graphs;

import java.util.*;

// only possible for directed acyclic graph
public class TopologicalSort {
    public static void main(String[] args) {

        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(5,0);
        graph.addEdge(4,0);
        graph.addEdge(5,2);
        graph.addEdge(2,3);
        graph.addEdge(4,1);
        graph.addEdge(3,1);

        for (int i : doTopologicalSortingBFS(graph.v, graph.adjacencyList)) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> doTopologicalSortingDFS(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v+1];
        for (int i = 0; i <= v; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyList, visited, result);
            }
        }
        Collections.reverse(result);
        return result;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, List<Integer> result) {
        visited[i] = true;
        for (int node : adjacencyList.get(i)) {
            if (!visited[node]) {
                dfs(node, adjacencyList, visited, result);
            }
        }
        result.add(i);
    }

    private static List<Integer> doTopologicalSortingBFS(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            for (int node : adjacencyList.get(i)) {
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int node : adjacencyList.get(curr)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return result;
    }
}
