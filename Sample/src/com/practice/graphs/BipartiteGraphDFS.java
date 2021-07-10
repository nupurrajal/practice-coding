package com.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;

// can be colored using 2 colors s.t. no two adjacent nodes have the same color.
public class BipartiteGraphDFS {
    public static void main(String[] args) {
        // odd length cycle

//        Graph graph = new Graph(8);
//        graph.addEdge(1,2);
//        graph.addEdge(2,3);
//        graph.addEdge(2,8);
//        graph.addEdge(3,4);
//        graph.addEdge(8,5);
//        graph.addEdge(4,5);
//        graph.addEdge(5,6);
//        graph.addEdge(6,7);

        // even length cycle

        Graph graph = new Graph(8);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,4);
        graph.addEdge(6,5);
        graph.addEdge(4,5);
        graph.addEdge(5,7);
        graph.addEdge(7,8);

        System.out.println(isBipartitePossible(graph.v, graph.adjacencyList));
    }

    private static boolean isBipartitePossible(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] colors = new int[v+1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= v; i++) {
            if (colors[i] == -1) {
                return isBipartitePossibleUtil(i, adjacencyList, colors, 0);
            }
        }
        return true;
    }

    private static boolean isBipartitePossibleUtil(int i, ArrayList<ArrayList<Integer>> adjacencyList, int[] colors, int color) {
        colors[i] = color;
        for (int node : adjacencyList.get(i)) {
            if (colors[node] == -1) {
                if (!isBipartitePossibleUtil(node, adjacencyList, colors, (color+1) % 2))
                    return false;
            } else if (colors[node] == color) {
                return false;
            }
        }
        return true;
    }
}
