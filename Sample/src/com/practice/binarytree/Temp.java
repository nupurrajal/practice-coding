package com.practice.binarytree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        int[][] task = new int[3][2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                task[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(task, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int o1N = o1[0] + o1[1];
                int o2N = o2[0] + o2[1];
                return o1N-o2N;
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 2; j++) {
                System.out.print(task[i][j] + " ");
            }
        }
    }
}
