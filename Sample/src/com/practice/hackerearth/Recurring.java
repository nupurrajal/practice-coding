package com.practice.hackerearth;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Recurring {
    public static void main(String args[]) throws IOException {

        //write your code here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(divide(n,m));
        }
    }

    static String divide(long n, long m) {
        if (n == 0)
            return "0";
        String recurring = getRecurring(n, m);
        if (recurring.equals("")) {
            float answer = n / m;
            return String.valueOf(answer);
        } else {
            long quo = n / m;
            StringBuilder answer = new StringBuilder(String.valueOf(quo));
            answer.append(".(");
            answer.append(recurring);
            answer.append(")");
            return answer.toString();
        }
    }

    static String getRecurring(long n, long m) {
        long rem = n % m;
        LinkedHashSet<Long> remainders = new LinkedHashSet();
        StringBuilder result = new StringBuilder();
        while (rem != 0 && !remainders.contains(rem)) {
            remainders.add(rem);
            rem *= 10;
            result.append(rem/m);
            rem = rem % m;
        }

        if (rem == 0)
            return "";
        else {
            for (Long temp : remainders) {
                result.append(temp);
            }
            return result.toString();
        }
    }
}

/*

4
4 5
12 6
4 222
9 -100


2
4 5
12 6
 */