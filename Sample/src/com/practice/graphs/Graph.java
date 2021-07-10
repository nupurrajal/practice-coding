package com.practice.graphs;

import java.util.ArrayList;

public class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    Graph(int v) {
        this.v = v;
        for (int i = 0; i <= v; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge (int u, int v) {
        this.adjacencyList.get(u).add(v);
        this.adjacencyList.get(v).add(u);
    }
}

