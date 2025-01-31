package com.linkedin;

import java.util.Arrays;

public class MinCostPaintHouse {
    public static void main(String[] args) {
//        int[][] cost = new int[][] {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
//        int[][] cost = new int[][] {{1, 2, 3}, {1, 4, 6}};
        int[][] cost = new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
//        System.out.println(paintHouseRecursive(0, -1, cost));
        int[][] dp = new int[cost.length][3+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        System.out.println(paintHouseMemo(0, -1, cost, dp));
//        System.out.println(paintHouseBottomUp(cost));
    }

    private static int paintHouseRecursive(int i, int lastPainted, int[][] cost) {
        if (i == cost.length) {
            return 0;
        }
        int redCost = Integer.MAX_VALUE, blueCost = Integer.MAX_VALUE, greenCost = Integer.MAX_VALUE;
        if (lastPainted != 0) {
            redCost = cost[i][0] + paintHouseRecursive(i+1, 0, cost);
        }
        if (lastPainted != 1) {
            blueCost = cost[i][1] + paintHouseRecursive(i+1, 1, cost);
        }
        if (lastPainted != 0) {
            greenCost = cost[i][2] + paintHouseRecursive(i+1, 2, cost);
        }

        return Math.min(redCost, Math.min(blueCost, greenCost));
    }

    // to be fixed
    private static int paintHouseMemo(int i, int lastPainted, int[][] cost, int[][] dp) {
        if (i == cost.length) {
            return 0;
        }
        int lastPaintedIndex = lastPainted + 1;
        if (dp[i][lastPainted] != -1) {
            return dp[i][lastPainted];
        }
        int redCost = Integer.MAX_VALUE, blueCost = Integer.MAX_VALUE, greenCost = Integer.MAX_VALUE;
        if (lastPainted != 0) {
            dp[i][0] = redCost = cost[i][0] + paintHouseMemo(i+1, 0, cost, dp);
        }
        if (lastPainted != 1) {
            dp[i][1] = blueCost = cost[i][1] + paintHouseMemo(i+1, 1, cost, dp);
        }
        if (lastPainted != 2) {
            dp[i][2] = greenCost = cost[i][2] + paintHouseMemo(i+1, 2, cost, dp);
        }
        return dp[i][lastPainted] = Math.min(redCost, Math.min(blueCost, greenCost));
    }

    private static int paintHouseBottomUp(int[][] cost) {
        int[] dp = new int[]{0,0,0};
        for (int i = 0; i < cost.length; i++) {
            int red = cost[i][0] + Math.min(dp[1], dp[2]);
            int blue = cost[i][1] + Math.min(dp[0], dp[2]);
            int green = cost[i][2] + Math.min(dp[0], dp[1]);
            dp = new int[]{red, blue, green};
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    // https://leetcode.ca/2016-08-21-265-Paint-House-II/
    private static int paintHouseBottomUpKColors(int[][] cost) {
        int[][] dp = new int[cost.length][cost[0].length];
        int length = cost.length, colors = cost[0].length;
        System.arraycopy(cost[0], 0, dp[0], 0, colors);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < colors; j++) {
                int prevMin = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (j == k) {
                        continue;
                    }
                    prevMin = Math.min(prevMin, dp[i-1][j]);
                }
                dp[i][j] = cost[i][j] + prevMin;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < colors; i++)
            minCost = Math.min(minCost, dp[length - 1][i]);
        return minCost;
    }
}
