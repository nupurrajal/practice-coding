package com.practice.dp;

import java.util.Map;
import java.util.Scanner;

public class ScrambledString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
//        int n = s1.length();
//        System.out.println(s1.substring(n-3,n) + " " + s1.substring(0, 3));
        System.out.println(isS2ScrambledOfS1Recursive(s1, s2));
    }

    private static boolean isS2ScrambledOfS1Recursive(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        if(n<=1) {
            return false;
        }
        for (int k = 1; k <= n-1; k++) {
            boolean case1 = isS2ScrambledOfS1Recursive(s1.substring(0, k), s2.substring(0, k)) && isS2ScrambledOfS1Recursive(s1.substring(k, n), s2.substring(k, n));
            boolean case2 = isS2ScrambledOfS1Recursive(s1.substring(n-k, n), s2.substring(0, k)) && isS2ScrambledOfS1Recursive(s1.substring(0, n-k), s2.substring(k, n));
            if(case1 || case2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isS2ScrambledOfS1BottomUp(String s1, String s2, Map<String, Boolean> mapVal) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        if(n<=1) {
            return false;
        }
        StringBuilder key = new StringBuilder(s1);
        key.append(" ");
        key.append(s2);
        if (mapVal.containsKey(key.toString())) {
            return mapVal.get(key);
        }
        boolean flag = false;
        for (int k = 1; k <= n-1; k++) {
            boolean case1 = isS2ScrambledOfS1Recursive(s1.substring(0, k), s2.substring(0, k)) && isS2ScrambledOfS1Recursive(s1.substring(k, n), s2.substring(k, n));
            boolean case2 = isS2ScrambledOfS1Recursive(s1.substring(n-k, n), s2.substring(0, k)) && isS2ScrambledOfS1Recursive(s1.substring(0, n-k), s2.substring(k, n));
            if(case1 || case2) {
                mapVal.put(key.toString(), true);
                flag = true;
            }
        }
        if (!flag)
            mapVal.put(key.toString(), false);
        return mapVal.get(key.toString());
    }
}

/*
great
grate
 */