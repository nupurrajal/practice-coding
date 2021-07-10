package com.test;

import java.util.*;

public class HRSort {

    public static List<Integer> itemsSort(List<Integer> items) {
        // Write your code here
        HashMap<Integer, Integer> countOfProd = new HashMap<>();
        for (int item : items) {
            int val = 1;
            if (countOfProd.containsKey(item)) {
                val = countOfProd.get(item)+1;
            }
            // countOfProd.put(item, countOfProd.getOrDefault(item, 0)+1);
            countOfProd.put(item, val);
        }

        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(countOfProd.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>> () {

            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() != e2.getValue()) {
                    return e1.getValue()-e2.getValue();
                } else {
                    return e1.getKey()-e2.getKey();
                }
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            while (count-- > 0) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for (int i : itemsSort(arr)) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
