package com.practice.graphs;

import java.util.ArrayList;

public class DirectedGraph {
    int v;
    ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    DirectedGraph(int v) {
        this.v = v;
        for (int i = 0; i <= v; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge (int u, int v) {
        this.adjacencyList.get(u).add(v);
    }
}
