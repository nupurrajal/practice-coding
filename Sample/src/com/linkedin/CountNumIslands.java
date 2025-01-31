package com.linkedin;

public class CountNumIslands {

    static int[][] steps = new int[][]{{-1,-1}, {-1,1}, {1,-1}, {1,1}, {0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'0', '1'}, {'1', '0'}, {'1', '1'}, {'1', '0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    dfs(grid, i, j, row, col, vis);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int row, int col, boolean[][] vis) {
        vis[i][j] = true;
        for (int[] step : steps) {
            int newRow = i + step[0];
            int newCol = j + step[1];
            if (isValid(grid, newRow, newCol, row, col, vis)) {
                dfs(grid, newRow, newCol, row, col, vis);
            }
        }
    }

    private static boolean isValid(char[][] grid, int i, int j, int row, int col, boolean[][] vis) {
        if (i < 0 || j < 0 || j >= col || i >= row) {
            return false;
        }
        return grid[i][j] == '1' && !vis[i][j];
    }
}
