package com.practice.binarytree;

public class CheckSubtree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.right.left.left = new BinaryTree(9);

        BinaryTree t1 = new BinaryTree(2);
        t1.left = new BinaryTree(4);
        t1.right = new BinaryTree(5);
        t1.left.left = new BinaryTree(8);

        System.out.println(isT1SubtreeOfRoot(root, t1));
    }

    private static boolean isT1SubtreeOfRoot(BinaryTree root, BinaryTree t1) {
        if (root == null && t1 == null) {
            return true;
        }
        if (root == null || t1 == null) {
            return false;
        }
        if (root.data == t1.data) {
            return isT1SubtreeOfRoot(root.left, t1.left) && isT1SubtreeOfRoot(root.right, t1.right);
        }
        return isT1SubtreeOfRoot(root.left, t1) || isT1SubtreeOfRoot(root.right, t1);
    }
}
