package com.linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/
public class PairWithGreatestProduct {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 30, 35};
        int[] arr1 = {42, 68, 35, 1, 70, 25};
        System.out.println(pairProductGreatest(arr1));
    }

    private static int pairProductGreatest(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = n-1; i >= 0; i--) {
            int prod = arr[i];
            for (int j = 0; j < i && arr[j] <= Math.sqrt(prod); j++) {
                if (prod % arr[j] == 0) {
                    int result = prod / arr[j];
                    if ((result != arr[j] && arrMap.containsKey(result) && (prod != result || arrMap.get(prod) > 1)) ||
                        (result == arr[j] && arrMap.containsKey(result) && arrMap.get(result) > 1)) {
                        return prod;
                    }
                }
            }
        }
        return -1;
    }
}
