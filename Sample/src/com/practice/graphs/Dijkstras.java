package com.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstras {
    public static void main(String[] args) {

        WeightedGraph weightedGraph = new WeightedGraph(5);
        weightedGraph.addEdge(1,2,2);
        weightedGraph.addEdge(1,4,1);
        weightedGraph.addEdge(2,3,4);
        weightedGraph.addEdge(4,3,3);
        weightedGraph.addEdge(2,5,5);
        weightedGraph.addEdge(3,5,1);
        int source = 1;
        for (int i : findShortestPathFromSource(source, weightedGraph.v, weightedGraph.adjacencyList)) {
            System.out.print(i + " ");
        }
    }

    private static int[] findShortestPathFromSource(int source, int v, ArrayList<ArrayList<int[]>> adjacencyList) {
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        // priority queue with distance as identifier to reduce number of comparisons
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, source});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] node : adjacencyList.get(curr[1])) {
                int tempD = curr[0] + node[1];
                if (distance[node[0]] > tempD) {
                    distance[node[0]] = tempD;
                    queue.add(new int[]{tempD, node[0]});
                }
            }
        }
        return distance;
    }
}
