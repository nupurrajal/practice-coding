package com.practice.binarytree;

public class DiameterOfBT {

    private static int result = 0;

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(1);
        root.right = new BinaryTree(1);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(1);
        root.right.right = new BinaryTree(1);
        root.left.right.left = new BinaryTree(1);
        root.left.right.right = new BinaryTree(1);
        root.right.right.right = new BinaryTree(1);
//        root.left = new BinaryTree(1);
//        root.left = new BinaryTree(1);
//        root.left = new BinaryTree(1);
//        root.left = new BinaryTree(1);
//        root.left = new BinaryTree(1);
//        root.left = new BinaryTree(1);
        diameterOfBinaryTree(root);
        System.out.println(result);
    }

    private static int diameterOfBinaryTree(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int temp = 1 + Math.max(left, right);
        //int ans = Math.max(temp, 1+left+right);
//        int ans = 1+left+right;
        result = Math.max(result, 1+left+right);
        return temp;
    }
}
