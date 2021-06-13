package com.practice.hackerearth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TasksOptimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] task = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                task[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(task, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(solve(task, t, 0, task[0][0], n));
    }

    private static int solve (int[][] task, int timeRem, int currIndex, int jump, int n) {
        if (currIndex == n - 1) {
            return 0;
        }
        if (timeRem <= 0) {
            return 0;
        }
        int currTimeTaken = task[currIndex][1] + jump + task[currIndex][0];

        if (timeRem >= currTimeTaken) {
            return 1 + solve(task, timeRem - currTimeTaken, currIndex + 1, task[currIndex + 1][0] - task[currIndex][0], n);
        } else {
            return solve(task, timeRem - task[currIndex][0], currIndex, task[currIndex][0], n);
        }
    }
}
