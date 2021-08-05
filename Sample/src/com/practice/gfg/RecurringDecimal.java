package com.practice.gfg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecurringDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m == 0) {
            System.out.println("Not possible");
            System.exit(1);
        }
        StringBuilder result = new StringBuilder(String.valueOf(n/m));
        if (!result.toString().isEmpty()) {
            result.append(".");
            result.append(decimalPartOfDivision(n, m));
        }
        System.out.println(result);
        sc.close();
    }

    private static String decimalPartOfDivision(int n, int m) {
        StringBuilder result = new StringBuilder();
        int rem = n % m;
        Map<Integer, Integer> map = new HashMap<>();
        while(rem != 0 && !map.containsKey(rem)) {
            map.put(rem, result.length());
            rem *= 10;
            result.append(rem/m);
            rem = rem%m;
        }
        if (map.containsKey(rem)) {
            return result.substring(map.get(rem));
        }
        return  "";
    }
}

