package com.linkedin;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchElement(nums, 0));
//        System.out.println(searchElement(nums, 3));
    }

    private static int searchElement(int[] arr, int target) {
        int pivot = getPivot(arr, 0, arr.length-1);
        if (pivot == -1) {
            return doBinarySearch(arr, 0, arr.length-1, target);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        if (target < arr[0]) {
            return doBinarySearch(arr, pivot+1, arr.length-1, target);
        }
        return doBinarySearch(arr, 0, pivot-1, target);
    }

    private static int doBinarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) /2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return doBinarySearch(arr, low, mid-1, target);
        } else {
            return doBinarySearch(arr, mid+1, high, target);
        }
    }

    private static int getPivot(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (mid > low && arr[mid] < arr[mid-1]) {
            return mid-1;
        }
        if (mid < high && arr[mid] > arr[mid+1]) {
            return mid;
        }
        if (arr[low] >= arr[mid]) {
            return getPivot(arr, low, mid-1);
        }
        return getPivot(arr, mid+1, high);
    }
}
