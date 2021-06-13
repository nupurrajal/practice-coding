package com.practice.gfg;

import java.util.Arrays;
import java.util.Scanner;

public class FarthestSmallest {
    static int[] farNumber(int N, int Arr[])
    {
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(Arr[i], i);
        }
        Arrays.sort(pairs, (p1, p2) -> p1.value-p2.value);
        for (int i = 0; i < N; i++) {
            Pair temp = pairs[i];
            int currIndex = temp.index;
            int k = i-1;
            while (k >= 0) {
                if (pairs[k].index > currIndex) {
                    res[currIndex] = pairs[k].index;
                    break;
                }
                k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = farNumber(n, arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}

class Pair {
    int value;
    int index;

    Pair (int v, int i) {
        this.value = v;
        this.index = i;
    }
}

/*
5
3 1 5 2 4
 */