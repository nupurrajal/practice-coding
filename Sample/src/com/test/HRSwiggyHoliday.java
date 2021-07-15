package com.test;

import java.util.ArrayList;
import java.util.Scanner;

class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adjacent;

    Graph(int v) {
        this.v = v;
        this.adjacent = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
    }

    void addEdge (int u, int v) {
        this.adjacent.get(u).add(v);
        this.adjacent.get(v).add(u);
    }
}

public class HRSwiggyHoliday {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < e; i++) {
            graph.addEdge(sc.nextInt()-1, sc.nextInt()-1);
        }
        int w = sc.nextInt();
        int[][] holidays = new int[n][w];
        int maxStart=0, maxIndex=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                holidays[i][j] = sc.nextInt();
                if (j == 0 && holidays[i][j] > maxStart) {
                    maxStart = holidays[i][j];
                    maxIndex = i;
                }
            }
        }
        System.out.println(maxHolidays(n, e, graph, w, holidays, maxIndex, maxStart));
        sc.close();
    }

    private static int maxHolidays(int n, int e, Graph graph, int w, int[][] holidays, int maxIndex, int maxStart) {
        int result = holidays[maxIndex][0];
        int weekNo = 1;
        while (weekNo < w) {
            maxStart = 0;
            for (int i : graph.adjacent.get(maxIndex)) {
                if (holidays[i][weekNo] > maxStart) {
                    maxStart = holidays[i][weekNo];
                    maxIndex = i;
                }
            }
            result += maxStart;
            weekNo++;
        }
        return result;
    }
}
