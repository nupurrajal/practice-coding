package com.practice.binarytree;

public class CheckBalancedBT {
    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);

        System.out.println(checkIfBTBalanced(root));
    }

    private static boolean checkIfBTBalanced(BinaryTree root) {
        int leftHt = checkHeight(root.left);
        int rightHt = checkHeight(root.right);
        return Math.abs(leftHt-rightHt) <= 1;
    }

    private static int checkHeight(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(checkHeight(root.left), checkHeight(root.right));
    }
}
