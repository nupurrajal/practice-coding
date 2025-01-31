package com.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) {
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(printNumberOfIslands(grid));
    }

    private static int printNumberOfIslands(char[][] grid) {
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    visitIslands(i, j, grid.length, grid[0].length, grid);
                }
            }
        }
        return noOfIslands;
    }

    private static void visitIslands(int i, int j, int n, int m, char[][] grid) {
        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] d : directions) {
                int dx = node[0] + d[0], dy = node[1] + d[1];
                if (dx >= i && dx < n && dy >= 0 && dy < m && grid[dx][dy] == '1') {
                    queue.add(new int[]{dx, dy});
                    grid[dx][dy] = '0';
                }
            }
        }
    }
}
