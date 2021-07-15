package com.practice.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ThreeNode {
    int src, dest, cost;
    ThreeNode(int s, int d, int c) {
        this.src = s;
        this.dest = d;
        this.cost = c;
    }
}

public class KruskalsAlgorithm {

    static int findParent (int i, int[] parent) {
        if (i == parent[i])
            return i;
        return findParent(parent[i], parent);
    }

    static void union (int u, int v, int[] parent, int[] rank) {

    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<ThreeNode> adjacencyList = new ArrayList<>();

        adjacencyList.add(new ThreeNode(0,1,2));
        adjacencyList.add(new ThreeNode(0,3,6));
        adjacencyList.add(new ThreeNode(1,3,8));
        adjacencyList.add(new ThreeNode(1,2,3));
        adjacencyList.add(new ThreeNode(1,4,5));
        adjacencyList.add(new ThreeNode(2,4,7));
        int k = 0;
        for (int i : kruskalsAlgoForMST(v, adjacencyList)) {
            System.out.println(k + " : " + i);
            k++;
        }
    }

    private static int[] kruskalsAlgoForMST(int v, ArrayList<ThreeNode> adjacencyList) {
        int[] res = new int[v+1];
        Collections.sort(adjacencyList, new Comparator<ThreeNode>() {
            @Override
            public int compare(ThreeNode o1, ThreeNode o2) {
                return o1.cost-o2.cost;
            }
        });
        int[] parent = new int[v];
        int[] rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        int costMST = 0;
        ArrayList<ThreeNode> mst = new ArrayList<>();
        for (ThreeNode curr : adjacencyList) {
            if (findParent(curr.src, parent) != findParent(curr.dest, parent)) {
                costMST += curr.cost;
                mst.add(curr);
                union(curr.src, curr.dest, parent, rank);
            }
        }
        System.out.println(costMST);
        return res;
    }
}
