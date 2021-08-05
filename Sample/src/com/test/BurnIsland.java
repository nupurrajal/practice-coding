package com.test;

import java.util.LinkedList;
import java.util.Queue;

/*

[2, 1, 0
 0, 0, 1  -> This case will take 2 units of time to destroy the whole set of islands.
 1, 1, 2]

 */

public class BurnIsland {

    public static int findMinimumTimeToBurn (int[][] island) {
        Queue<int[]> industrialCoordinates = new LinkedList();
        int row = island.length, col = island[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (island[i][j] == 2) {
                    industrialCoordinates.add(new int[]{i, j, 0});
                }
            }
        }
        if (industrialCoordinates.size() == 0) {
            return -1;
        }
        int maxTime = 0;
        while (!industrialCoordinates.isEmpty()) {
            int[] curr = industrialCoordinates.poll();
            if (island[curr[0]][curr[1]] != -1) {
                island[curr[0]][curr[1]] = -1;
                // left
                if (isSafe(island, curr[0] - 1, curr[1], row, col)) {
                    maxTime = Math.max(maxTime, curr[2] + 1);
                    industrialCoordinates.add(new int[]{curr[0] - 1, curr[1], curr[2] + 1});
                }
                if (isSafe(island, curr[0] + 1, curr[1], row, col)) {
                    maxTime = Math.max(maxTime, curr[2] + 1);
                    industrialCoordinates.add(new int[]{curr[0] + 1, curr[1], curr[2] + 1});
                }
                if (isSafe(island, curr[0], curr[1] - 1, row, col)) {
                    maxTime = Math.max(maxTime, curr[2] + 1);
                    industrialCoordinates.add(new int[]{curr[0], curr[1] - 1, curr[2] + 1});
                }
                if (isSafe(island, curr[0], curr[1] + 1, row, col)) {
                    maxTime = Math.max(maxTime, curr[2] + 1);
                    industrialCoordinates.add(new int[]{curr[0], curr[1] + 1, curr[2] + 1});
                }
            }
        }
        return maxTime;
    }

    private static boolean isSafe(int[][] island, int x, int y, int row, int col) {
        if (x < 0 || x >= col || y < 0 || y >= row || island[x][y] == -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] island = new int[3][3];

        island[0] = new int[] {1,1,0};
        island[1] = new int[] {0,0,1};
        island[2] = new int[] {1,1,2};

        System.out.println(findMinimumTimeToBurn(island));
    }

}