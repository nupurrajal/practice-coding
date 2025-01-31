package com.linkedin;

import java.util.*;

public class MaxUniquePieces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Integer> result = divideIntoUniquePieces(s);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> divideIntoUniquePieces(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, lastOccurrence.get(ch));
            if (i == end) {
                result.add(end - start + 1);
                start = i+1;
            }
        }
        return result;
    }
}

/*
ecedfdfaa
 */