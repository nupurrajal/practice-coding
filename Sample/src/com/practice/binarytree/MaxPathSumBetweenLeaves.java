package com.practice.binarytree;

public class MaxPathSumBetweenLeaves {

    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(10);
        root.left.left = new BinaryTree(20);
        root.left.right = new BinaryTree(1);
        root.right.right = new BinaryTree(-25);
        root.right.right.left = new BinaryTree(3);
        root.right.right.right = new BinaryTree(4);
        printMaximumPathSumBetweenTwoLeafNodes(root);
        System.out.println(result);
    }

    private static int printMaximumPathSumBetweenTwoLeafNodes(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,printMaximumPathSumBetweenTwoLeafNodes(root.left));
        int right = Math.max(0,printMaximumPathSumBetweenTwoLeafNodes(root.right));
//        int temp = root.data + Math.max(left, right);
        result = Math.max(result, root.data + left + right);
        return root.data + Math.max(left, right);
    }
}
