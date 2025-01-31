package com.linkedin;

import java.util.HashMap;
import java.util.Map;

public class FlipOnesToMakeZero {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1}, {1,1,1}, {0,1,0}};
        System.out.println(removeOnes(grid));
    }

    private static int removeOnes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        String initialState = gridToString(grid);
        Map<String, Integer> memo = new HashMap<>();
        return dfs(grid, n, m, initialState, memo);
    }

    private static int dfs(int[][] grid, int n, int m, String currState, Map<String, Integer> memo) {
        if (currState.equals(getZeroString(n, m))) {
            return 0;
        }
        if (memo.containsKey(currState)) {
            return memo.get(currState);
        }
        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int[][] newGrid = copyMatrix(grid);
                    clearRowAndCol(newGrid, i, j);
                    String newState = gridToString(newGrid);
                    minOps = Math.min(minOps, 1 + dfs(newGrid, n, m, newState, memo));
                }
            }
        }
        memo.put(currState, minOps);
        return minOps;
    }

    private static void clearRowAndCol(int[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = 0;
        }
        for (int i = 0; i < grid[0].length; i++) {
            grid[row][i] = 0;
        }
    }

    private static int[][] copyMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] newGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, m);
        }
        return newGrid;
    }

    private static boolean isAllZero(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return false;
            }
        }
        return true;
    }

    private static String getZeroString(int row, int col) {
        return "0".repeat(row * col);
    }

    private static String gridToString(int[][] grid) {
        StringBuilder s = new StringBuilder();
        for (int[] row : grid) {
            for (int i : row) {
                s.append(i);
            }
        }
        return s.toString();
    }
}
