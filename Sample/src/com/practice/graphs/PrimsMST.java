package com.practice.graphs;

// weighted undirected graph
// spanning tree - convert graph with n nodes into a tree with n-1 edges and every node is reachable from every other node.
// minimum st -> sum of weights of n-1 edges is to be minimum.

import java.util.ArrayList;
import java.util.Arrays;

public class PrimsMST {
    public static void main(String[] args) {

        WeightedGraph weightedGraph = new WeightedGraph(4);

        weightedGraph.addEdge(0,1,2);
        weightedGraph.addEdge(0,3,6);
        weightedGraph.addEdge(1,3,8);
        weightedGraph.addEdge(1,2,3);
        weightedGraph.addEdge(1,4,5);
        weightedGraph.addEdge(2,4,7);

//        WeightedGraph weightedGraph = new WeightedGraph(6);
//
//        weightedGraph.addEdge(1,4,1);
//        weightedGraph.addEdge(5,4,9);
//        weightedGraph.addEdge(5,1,4);
//        weightedGraph.addEdge(4,2,3);
//        weightedGraph.addEdge(1,2,2);
//        weightedGraph.addEdge(4,3,5);
//        weightedGraph.addEdge(3,6,8);
//        weightedGraph.addEdge(3,2,3);
//        weightedGraph.addEdge(2,6,7);

        int[] newGraph = primsAlgorithmBruteForce (weightedGraph.v, weightedGraph.adjacencyList);
        int i = 0;
        for (int curr : newGraph) {
            System.out.println(i + " : " + curr);
            i++;
        }
    }

    private static int[] primsAlgorithmBruteForce (int v, ArrayList<ArrayList<int[]>> adjacencyList) {
        int[] key = new int[v+1];
        int[] parent = new int[v+1];
        boolean[] mst = new boolean[v+1];
        Arrays.fill(parent, -1);
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        for (int i = 0; i < v-1; i++) {
            int min = Integer.MAX_VALUE, minIndex=0;
            for (int k = 0; k <= v; k++) {
                if (!mst[k] && key[k] < min) {
                    min = key[k];
                    minIndex = k;
                }
            }
            mst[minIndex] = true;
            for (int[] node : adjacencyList.get(minIndex)) {
                if (!mst[node[0]] && node[1] < key[node[0]]) {
                    parent[node[0]] = minIndex;
                    key[node[0]] = node[1];
                }
            }
        }
        return parent;
    }
}
