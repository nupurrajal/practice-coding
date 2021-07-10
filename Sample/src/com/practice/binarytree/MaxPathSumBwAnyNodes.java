package com.practice.binarytree;

public class MaxPathSumBwAnyNodes {

    private static int result = 0;

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(3);

        printMaximumPathSumBetweenAnyTwoNodes(root);
        System.out.println(result);
    }

    private static int printMaximumPathSumBetweenAnyTwoNodes(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int left = printMaximumPathSumBetweenAnyTwoNodes(root.left);
        int right = printMaximumPathSumBetweenAnyTwoNodes(root.right);
        int temp = Math.max(root.data, root.data + Math.max(left, right));
        int ans = Math.max(temp, root.data + left + right);
        result = Math.max(ans, result);
        return temp;
    }
}
