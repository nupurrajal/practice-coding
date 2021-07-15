package com.practice.graphs;

public class DisjointSet {
    int v;
    int[] parent;
    int[] rank;

    DisjointSet(int v) {
        this.v = v;
        this.parent = new int[v+1];
        this.rank = new int[v+1];
        for (int i = 1; i <= v; i++) {
            this.parent[i] = i;
        }
    }

    void union (int src, int dest) {
        src = findParent(src);
        dest = findParent(dest);
        if (rank[src] < rank[dest]) {
            parent[src] = dest;
        } else if (rank[dest] < rank[src]) {
            parent[dest] = src;
        } else {
            parent[dest] = src;
            rank[src]++;
        }
    }

    int findParent (int node) {
        if (node == parent[node]) {
            return node;
        }
        // path compression
        return parent[node] = findParent(parent[node]);
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.union(1,2);
        System.out.println(disjointSet.findParent(2));
        disjointSet.union(2,3);
        disjointSet.union(4,5);
        disjointSet.union(6,7);
        disjointSet.union(5,6);
        System.out.println(disjointSet.findParent(1));
        disjointSet.union(3,7);

        for (int i = 1; i <= 7; i++) {
            System.out.print(disjointSet.findParent(i) + " ");
        }
    }
}
