package com.linkedin;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = doPartitionLabels(s);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        Map<Integer, Integer> m = new TreeMap<>();
    }

    private static List<Integer> doPartitionLabels(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), k -> new TreeSet<>()).add(i);
        }
        List<List<Integer>> intervals = new ArrayList<>();
        for (Character ch : map.keySet()) {
            TreeSet<Integer> indices = map.get(ch);
            intervals.add(Arrays.asList(indices.first(), indices.last()));
        }
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));
        int i = 0;
        List<List<Integer>> merged = new ArrayList<>();
        while (i < intervals.size()){
            int currStart = intervals.get(i).get(0);
            int currEnd = intervals.get(i).get(1);
            while (i < intervals.size() - 1 && intervals.get(i+1).get(0) <= currEnd) {
                i++;
                currEnd = Math.max(currEnd, intervals.get(i).get(1));
            }
            merged.add(Arrays.asList(currStart, currEnd));
            i++;
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> curr : merged) {
            result.add(curr.get(1) - curr.get(0) + 1);
        }
        return result;
    }
}
