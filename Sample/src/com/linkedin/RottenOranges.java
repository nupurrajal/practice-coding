package com.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int minTime = 0;
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] d : directions) {
                    int dx = d[0] + curr[0], dy = d[1] + curr[1];
                    if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                        grid[dx][dy] = 2;
                        queue.add(new int[]{dx, dy});
                    }
                }
            }
            minTime++;
        }
        for (int[] i : grid) {
            for (int j : i) {
                if (j == 1) {
                    return -1;
                }
            }
        }
        return minTime == 0 ? 0 : minTime-1;
    }
}
