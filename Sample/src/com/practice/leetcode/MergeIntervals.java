package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MergeIntervals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int[][] result = merge(intervals);
        for (int[] curr : result) {
            System.out.println(curr[0] + " " + curr[1]);
        }
        String s1 = "pep ";
        s1.concat("talk");
        System.out.println(s1);
        sc.close();
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int stopTime = intervals[i][1];
            int startTime = intervals[i][0];
            while (i+1 < intervals.length && intervals[i+1][0] <= stopTime) {
                i++;
                stopTime = Math.max(intervals[i][1], stopTime);
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(startTime);
            temp.add(stopTime);
            res.add(temp);
        }
        int[][] result = new int[res.size()][2];
        int i = 0;
        for (ArrayList<Integer> curr : res) {
            result[i][0] = curr.get(0);
            result[i][1] = curr.get(1);
            i++;
        }
        return result;
    }
}

/*
4
1 3
2 6
8 10
15 18

2
1 4
2 3
 */