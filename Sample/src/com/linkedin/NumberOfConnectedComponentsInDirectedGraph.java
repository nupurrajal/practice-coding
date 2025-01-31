package com.linkedin;

public class NumberOfConnectedComponentsInDirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        DSUNew dsuNew = new DSUNew(n);
        int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
        for (int[] e : edges) {
            dsuNew.union(e[0], e[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsuNew.parent[i] == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}

class DSUNew {
    int[] parent;
    int[] rank;
    int n;

    DSUNew(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    void union(int x, int y) {
        int px = findParent(x), py = findParent(y);
        if (px == py) {
            return;
        }
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    int findParent(int x) {
        if (x != parent[x]) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

}
