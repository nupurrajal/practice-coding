package com.practice.binarytree;

public class FirstCommonAncestor {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(findFirstCommonAncestor(root,2, 3).data);
    }

    private static BinaryTree findFirstCommonAncestor(BinaryTree root, int i, int j) {
        if (root == null) {
            return null;
        }
        if (root.data == i || root.data == j) {
            return root;
        }
        BinaryTree left = findFirstCommonAncestor(root.left, i, j);
        BinaryTree right = findFirstCommonAncestor(root.right, i, j);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
