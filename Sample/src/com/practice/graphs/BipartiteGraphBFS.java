package com.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// can be colored using 2 colors s.t. no two adjacent nodes have the same color.
public class BipartiteGraphBFS {
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
        graph.addEdge(2,7);
        graph.addEdge(3,4);
        graph.addEdge(7,6);
        graph.addEdge(4,5);
        graph.addEdge(6,5);
        graph.addEdge(5,8);

        System.out.println(isBipartitePossible(graph.v, graph.adjacencyList));
    }

    private static boolean isBipartitePossible(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] colors = new int[v+1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= v; i++) {
            if (colors[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 0;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int child : adjacencyList.get(node)) {
                        if (colors[child] == -1) {
                            colors[child] = (colors[node] +1) % 2;
                            queue.add(child);
                        } else if (colors[child] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
