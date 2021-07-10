package com.practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,7);
        graph.addEdge(3,5);
        graph.addEdge(5,7);
        graph.addEdge(4,6);
        for (int i : bfs(0, graph)) {
            System.out.print(i + " ");
        }
    }


    private static List<Integer> bfs(int begin, Graph graph) {
        boolean[] visited = new boolean[graph.v + 1];
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= graph.v; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    result.add(node);
                    for (Integer curr : graph.adjacencyList.get(node)) {
                        if (!visited[curr]) {
                            visited[curr] = true;
                            queue.add(curr);
                        }
                    }
                }
            }
        }
        return result;
    }
}
