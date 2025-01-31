package com.linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinStepsForKnight {

    static int minStep = Integer.MAX_VALUE;
    static int[][] steps = new int[][]{{-2,-1}, {2,-1}, {2,1}, {2,-1},
            {1, -2}, {-1,-2}, {-1,2}, {1,2}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] KnightPos = new int[2];
        KnightPos[0] = sc.nextInt();
        KnightPos[1] = sc.nextInt();
        int[] TargetPos = new int[2];
        TargetPos[0] = sc.nextInt();
        TargetPos[1] = sc.nextInt();

        System.out.println(minStepToReachTargetBFS(KnightPos, TargetPos, N));
    }

    public static int minStepToReachTargetBFS(int[] KnightPos, int[] TargetPos, int N)
    {
        // Code here
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(KnightPos);
        visited[KnightPos[0]][KnightPos[1]] = true;
        int stepsCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                for (int[] step : steps) {
                    int newRow = x + step[0];
                    int newCol = y + step[1];
                    if (newRow == TargetPos[0] && newCol == TargetPos[1]) {
                        return stepsCount+1;
                    }
                    if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol]) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            stepsCount++;
        }
        return -1;
    }

    //Function to find out minimum steps Knight needs to reach target position.

    public static int minStepToReachTargetDFS(int[] KnightPos, int[] TargetPos, int N)
    {
        // Code here
        boolean[][] visited = new boolean[N][N];
        minStepToReachTargetDFS(KnightPos, TargetPos, N, 0, visited);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private static void minStepToReachTargetDFS(int[] KnightPos, int[] TargetPos, int N, int count, boolean[][] visited) {
        int x = KnightPos[0];
        int y = KnightPos[1];

        if (x == TargetPos[0] && y == TargetPos[1]) {
            minStep = Math.min(minStep, count);
            return ;
        }

        visited[x][y] = true;
        for (int[] step : steps) {
            int newRow = x + step[0];
            int newCol = y + step[1];
            if (newRow < N && newRow >= 0 && newCol < N && newCol >= 0 && !visited[newRow][newCol]) {
                minStepToReachTargetDFS(new int[]{newRow, newCol}, TargetPos, N, count + 1, visited);
            }
        }
    }
}

/*
6
4 5
1 1
 */