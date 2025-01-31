package com.linkedin;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallestWindowInStringForAnotherSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(smallestWindowNew(s1, s2));
    }

    private static int smallestWindow (String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        Map<Character, Integer> s2Map = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        int start = 0, matched = 0;
        Map<Character, Integer> found = new HashMap<>();
        for (int end = 0; end < s1.length(); end++) {
            char ch = s1.charAt(end);
            found.put(ch, found.getOrDefault(ch, 0) + 1);

            if (s2Map.containsKey(ch) && s2Map.get(ch) > 0) {
                matched++;
            }

            while (matched == s2.length()) {
                int currLen = end - start + 1;
                if (currLen < minCount) {
                    minCount = currLen;
                }

            }

        }
        return minCount;
    }

    public static String smallestWindowNew (String s1, String s2) {
        // Your code here
        if (s1.length() < s2.length()) {
            return "";
        }
        int[] res = new int[]{-1,-1};
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int have = 0, need = 0;
        int[] s1Map = new int[128];
        int[] s2Map = new int[128];
        for (char ch : s2.toCharArray()) {
            s2Map[ch]++;
        }
        for (int i : s2Map) {
            if (i > 0) {
                need++;
            }
        }
        while (end < s1.length()) {
            char ch = s1.charAt(end);
            s1Map[ch]++;

            if (s2Map[ch] > 0 && s2Map[ch] == s1Map[ch]) {
                have++;
            }
            while (have == need) {
                if (minLen > end-start+1) {
                    minLen = end-start+1;
                    res = new int[]{start, end};
                }
                char startChar = s1.charAt(start);
                s1Map[startChar]--;
                if (s2Map[startChar] > 0 &&
                        s1Map[startChar] < s2Map[startChar]) {
                    have--;
                }
                start++;
            }
            end++;
        }
        if (res[0] == -1 || res[1] == -1) {
            return "";
        }
        return s1.substring(res[0], res[1]+1);
    }


}

/*
timetopractice
toc
 */
