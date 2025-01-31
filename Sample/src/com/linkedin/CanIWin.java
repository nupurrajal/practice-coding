package com.linkedin;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/can-i-win/description/
public class CanIWin {
    public static void main(String[] args) {
        int maxChoosable = 1;
        int desiredTotal = 10;
        System.out.println(canIWin(maxChoosable, desiredTotal));
    }

    private static boolean canIWin(int maxChoosable, int desiredTotal) {
        int max = (maxChoosable * (maxChoosable + 1)) / 2;
        if (maxChoosable >= desiredTotal) {
            return true;
        }
        if (max < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(maxChoosable, desiredTotal, 0, memo);
    }

    private static boolean canIWin(int maxChoosable, int desiredTotal, int state, Map<Integer, Boolean> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        boolean result = false;
        for (int i = 1; i <= maxChoosable; i++) {
            boolean isAvailable = (state >> i) % 2 == 0;
            if (!isAvailable) continue;
            if (desiredTotal <= i) {
                result = true;
                break;
            }
            int newState = state | 1 << i;
            boolean rivalWins = canIWin(maxChoosable, desiredTotal - i, newState, memo);
            if (!rivalWins) {
                result = true;
                break;
            }
        }
        memo.put(state, result);
        return result;
    }
}