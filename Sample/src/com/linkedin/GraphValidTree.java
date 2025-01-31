package com.linkedin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {
    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(canGraphToTree(n, edges));
    }

    private static boolean canGraphToTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    adj.get(neighbour).remove(node);
                } else {
                    return false;
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
