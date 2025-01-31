package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String expression = "2-1-1";
        List<Integer> allEvaluations = getAllEvaluations(expression);
        for (Integer i : allEvaluations) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> getAllEvaluations(String expression) {
        int l = expression.length();
        List<Integer>[][] memo = new ArrayList[l][l];
        return differentWaysToCompute(expression, 0, l-1, memo);
    }

    private static List<Integer> differentWaysToCompute(String expression, int start, int end, List<Integer>[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        List<Integer> result = new ArrayList<>();
        if (start == end) {
            result.add(expression.charAt(start) - '0');
            return result;
        }
        if (start + 1 == end && Character.isDigit(expression.charAt(start))) {
            int ones = expression.charAt(end) - '0';
            int tens = expression.charAt(start) - '0';
            result.add((tens * 10) + ones);
            return result;
        }
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(expression.charAt(i))) {
                continue;
            }
            List<Integer> leftSide = differentWaysToCompute(expression, start, i-1, memo);
            List<Integer> rightSide = differentWaysToCompute(expression, i+1, end, memo);
            for (int l : leftSide) {
                for (int r : rightSide) {
                    switch (expression.charAt(i)) {
                        case '+': result.add(l + r); break;
                        case '-': result.add(l - r); break;
                        case '*': result.add(l * r); break;
                    }
                }
            }
        }
        return memo[start][end] = result;
    }
}
