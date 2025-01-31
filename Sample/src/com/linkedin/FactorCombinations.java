package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public static void main(String[] args) {
        int n = 84;
        List<List<Integer>> result = new ArrayList<>();
        findFactors(n, 2, new ArrayList<>(), result);
        for (List<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void findFactors(int n, int index, ArrayList<Integer> curr, List<List<Integer>> result) {
        if (n == 1 && curr.size() > 1) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (n % i == 0) {
                curr.add(i);
                findFactors(n/i, i, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
}
