package com.linkedin;

import com.practice.binarytree.BinaryTree;

public class DistanceBetweenNodesInBT {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(14);
        root.left = new BinaryTree(6);
        root.left.right = new BinaryTree(9);

    }

    static int findDist(BinaryTree root, int a, int b) {
        // Your code here
        BinaryTree LCA = LCAUtil(root, a, b);
        if (LCA == null) {
            return -1;
        }
        return findDist(LCA, a) + findDist(LCA, b);
    }

    static int findDist(BinaryTree root, int a) {
        if (root == null) {
            return -1;
        }
        if (root.data == a) {
            return 0;
        }
        int left = findDist(root.left, a);
        int right = findDist(root.right, a);
        if (left == -1 && right == -1) {
            return -1;
        }
        return 1 + (left == -1 ? right : left);
    }

    static BinaryTree LCAUtil(BinaryTree root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        BinaryTree left = LCAUtil(root.left, a, b);
        BinaryTree right = LCAUtil(root.right, a, b);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
}
