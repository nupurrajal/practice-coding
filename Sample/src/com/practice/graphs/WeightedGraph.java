package com.practice.graphs;

import java.util.ArrayList;

public class WeightedGraph {
    int v;
    ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
    WeightedGraph(int v) {
        this.v = v;
        for (int i = 0; i <= v; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge (int u, int v, int distance) {
        this.adjacencyList.get(u).add(new int[] {v, distance});
        this.adjacencyList.get(v).add(new int[] {u, distance});
    }
}
