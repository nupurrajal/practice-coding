package com.practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// idea - kahn's algo, if topological sort is not generated, then it contains cycle
public class CycleDetectionDirectedBFS {
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
//        directedGraph.addEdge(9,7);

//        DirectedGraph directedGraph = new DirectedGraph(4);
//        directedGraph.addEdge(1,2);
//        directedGraph.addEdge(2,3);
//        directedGraph.addEdge(3,4);
//        directedGraph.addEdge(4,2);

        System.out.println(containsCycleInDirectedGraph(directedGraph.v, directedGraph.adjacencyList));
    }

    private static boolean containsCycleInDirectedGraph(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] inDegree = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            for (int node : adjacencyList.get(i)) {
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int node : adjacencyList.get(curr)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }
        return count != v;
    }


}
