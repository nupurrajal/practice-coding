package com.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(2,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,6);

        for (int d : shortestPathFromStart(graph.v, graph.adjacencyList)) {
            System.out.print(d + " ");
        }
    }

    private static int[] shortestPathFromStart(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int node : adjacencyList.get(curr)) {
                if (distance[node] > 1 + distance[curr]) {
                    distance[node] = 1 + distance[curr];
                    queue.add(node);
                }
            }
        }
        return distance;
    }
}
