package com.practice.gfg;

import java.util.Scanner;

public class Quicksort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        doQuickSort(arr, 0, n-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    private static void doQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            doQuickSort(arr, low, pi-1);
            doQuickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        int temp;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}

/*
Pivot -
1. first element
2. last element
3. random element
4. median


7
10 80 30 90 40 50 70
 */