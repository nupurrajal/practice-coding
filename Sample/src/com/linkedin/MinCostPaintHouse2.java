package com.linkedin;

public class MinCostPaintHouse2 {
    public static void main(String[] args) {
        int[][] cost = new int[][]{
                        {1, 5, 3},
                        {2, 9, 4}
                       };
        System.out.println(minCostHousePaint2(cost));
    }

    private static int minCostHousePaint2(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length, k = cost[0].length;
        int min1 = 0, min2 = 0, lastColor = -1;
        for (int i = 0; i < n; i++) {
            int currMin1 = Integer.MAX_VALUE, currMin2 = Integer.MAX_VALUE, currMinIndex = -1;
            for (int j = 0; j < k; j++) {
                int currCost = cost[i][j];
                if (j != lastColor) {
                    currCost += min1;
                } else {
                    currCost += min2;
                }
                if (currCost < currMin1) {
                   currMin2 = currMin1;
                   currMin1 = currCost;
                   currMinIndex = j;
                } else if (currCost < currMin2) {
                    currMin2 = currCost;
                }
            }
            min1 = currMin1;
            min2 = currMin2;
            lastColor = currMinIndex;
        }
        return min1;
    }
}
