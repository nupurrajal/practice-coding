package com.linkedin;

import com.practice.binarytree.BinaryTree;

public class LCAOfBST {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(4);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(5);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);

        int p = 1, q = 5;
        System.out.println(getLCAOfBST(root, p, q));
    }

    private static int getLCAOfBST(BinaryTree root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root == null ? -1 : root.data;
        }
        if (root.data < p && root.data < q) {
            return getLCAOfBST(root.right, p, q);
        } else if (root.data > p && root.data > q) {
            return getLCAOfBST(root.left, p, q);
        }
        return root.data;
    }
}
