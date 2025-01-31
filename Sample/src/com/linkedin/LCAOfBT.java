package com.linkedin;

import com.practice.binarytree.BinaryTree;

public class LCAOfBT {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(8);
        root.right.right = new BinaryTree(9);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(6);
        root.left.right.right = new BinaryTree(7);

        BinaryTree n1 = root.left.left;
        BinaryTree n2 = root.left.right.right;

        System.out.println(findLCA(root, n1, n2));
    }

    private static Integer findLCA(BinaryTree root, BinaryTree n1, BinaryTree n2) {
        if (root == null || (root == n1 || root == n2)) {
            return root == null ? null : root.data;
        }
        Integer left = findLCA(root.left, n1, n2);
        Integer right = findLCA(root.right, n1, n2);
        if (left != null && right != null) {
            return root.data;
        }
        return left == null ? right : left;
    }
}
