package com.practice.dp;

import java.util.Scanner;

public class MinimumTicketCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] cost = new int[3];
        for (int i = 0; i < 3; i++) {
            cost[i] = sc.nextInt();
        }
        System.out.println(findMinimumCostForTickets(n, days, cost));
        sc.close();
    }

    private static int findMinimumCostForTickets(int n, int[] days, int[] costs) {
        int[] dp = new int[30];
        int d = 0; // d means the index of next travel day
        int lastday = days[days.length - 1];

        for (int i = days[0]; i <= lastday; i++) {
            if (i != days[d]) dp[i % 30] = dp[(i - 1) % 30]; // we don't have this day for travel, price as yesterday
            else { // i == days[d]
                dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0], Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1], dp[Math.max(i - 30, 0) % 30] + costs[2]));
                d++;
            }
        }
        return dp[lastday % 30];

    }
}

/*
6
1 4 6 7 8 20
2 7 15
 */
