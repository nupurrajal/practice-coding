package com.practice.binarytree;

import java.util.HashMap;

public class InorderSuccessor {

    private static HashMap<BinaryTree, BinaryTree> parentNode = new HashMap<>();

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(20);
        root.left = new BinaryTree(8);
        root.right = new BinaryTree(22);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(12);
        root.left.right.left = new BinaryTree(10);
        root.left.right.right = new BinaryTree(14);

        doInorderTraversal(root, null);

        System.out.println(inorderSuccessor(root, root.left.right.right));
    }

    private static int inorderSuccessor(BinaryTree root, BinaryTree temp) {
        if (root == null) {
            return -1;
        }
        if (root.equals(temp)) {
            return parentNode.get(root).data;
        }
        if (root.left != null) {
            return inorderSuccessor(root.left, temp);
        }
        if (root.right != null) {
            return inorderSuccessor(root.right, temp);
        }
        return -1;
    }

    private static void doInorderTraversal(BinaryTree root, BinaryTree parent) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left, parent);
        parentNode.put(root, root.left);
        doInorderTraversal(root.right, root);
    }
}
