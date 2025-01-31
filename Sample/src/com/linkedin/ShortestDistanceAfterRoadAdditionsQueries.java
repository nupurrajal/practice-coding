package com.linkedin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/
public class ShortestDistanceAfterRoadAdditionsQueries {

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2,4},{0,2},{0,4}};
        int[] result = shortestDistanceAfterQueries(n, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < n-1; i++) {
            adj.add(new ArrayList());
            adj.get(i).add(i+1);
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            res[i++] = shortestDistanceAfterQueries(n, 0, n-1, adj);
        }

        return res;
    }

    private static int shortestDistanceAfterQueries(int n, int start, int end, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        visited[start] = true;
        queue.add(start);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == end) {
                    return length;
                }
                for (int nodes : adj.get(curr)) {
                    if (!visited[nodes]) {
                        visited[nodes] = true;
                        queue.add(nodes);
                    }
                }
            }
            length++;
        }
        return length;
    }
}
