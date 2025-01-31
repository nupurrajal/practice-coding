package com.linkedin;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> merged = mergeIntervals(intervals);
        for (List<Integer> interval : merged) {
            System.out.println(interval.get(0) + " " + interval.get(1));
        }
    }

    private static List<List<Integer>> mergeIntervals(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int maxEnd = currEnd;
            int minStart = currStart;
            int j = i+1;
            while (j < intervals.length && intervals[j][0] <= currEnd && intervals[j][0] >= currStart) {
                maxEnd = Math.max(maxEnd, intervals[j][1]);
                currStart = Math.min(currStart, intervals[j][0]);
                currEnd = Math.max(currEnd, intervals[j][1]);
                j++;
            }
            List<Integer> currList = Arrays.asList(minStart, maxEnd);
            merged.add(currList);
            i = j;
        }
        return merged;
    }
}
