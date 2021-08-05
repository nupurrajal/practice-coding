package com.practice.graphs;

import java.util.*;

public class ShortestPathWeightedDAC {
    public static void main(String[] args) {

        DirectWeightedGraph graph = new DirectWeightedGraph(5);
        graph.addEdge(0,1, 2);
        graph.addEdge(0,4, 1);
        graph.addEdge(1,2, 3);
        graph.addEdge(4,2, 2);
        graph.addEdge(4,5, 4);
        graph.addEdge(2,3, 6);
        graph.addEdge(5,3, 1);

        for (int d : shortestPathFromStart(graph.v, graph.adjacencyList)) {
            System.out.print(d + " ");
        }
    }

    private static int[] shortestPathFromStart(int v, ArrayList<ArrayList<int[]>> adjacencyList) {
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] node : adjacencyList.get(curr)) {
                int tempD = node[1] + distance[curr];
                if (distance[node[0]] > tempD) {
                    distance[node[0]] = tempD;
                    queue.add(node[0]);
                }
            }
        }
        BitSet bitSet = new BitSet();
        return distance;
    }
}
