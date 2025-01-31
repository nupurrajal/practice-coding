package com.linkedin;

// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
public class OptimalGame {

    public static void main(String[] args) {
//        int[] coins = new int[]{5,3,7,10};
        int[] coins = new int[]{8,15,3,7};
        System.out.println(optimalGame(coins, 0, coins.length-1));
    }

    private static int optimalGame (int[] coins, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        int takeFirst = coins[begin] + Math.min(optimalGame(coins, begin+2, end), optimalGame(coins, begin+1, end-1));
        int takeSecond = coins[end] + Math.min(optimalGame(coins, begin+1, end-1), optimalGame(coins, begin, end-2));
        return Math.max(takeFirst, takeSecond);
    }
}
