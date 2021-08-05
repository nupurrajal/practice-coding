package com.practice.binarytree;

import java.util.Scanner;

public class MinimalBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = createNewBST(arr, 0, arr.length-1);
        printInorder(root);
        sc.close();
    }

    private static TreeNode createNewBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end+1) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createNewBST(arr, start, mid-1);
        root.right = createNewBST(arr, mid+1, end);
        return root;
    }

    static void printInorder (TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

/*
6
1 2 3 4 5 6
 */