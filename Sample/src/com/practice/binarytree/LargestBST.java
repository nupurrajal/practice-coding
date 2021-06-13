package com.practice.binarytree;

class TreeInfo {
    int min, max, size;
    boolean isBST;

    TreeInfo(int min, int max, int size, boolean isBST)
    {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

public class LargestBST {
    BinaryTree root;


    public static TreeInfo findLargestBST (BinaryTree root) {
        if (root == null)
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        TreeInfo left = findLargestBST(root.left);
        TreeInfo right = findLargestBST(root.right);

        TreeInfo info = null;

        if (left.isBST && right.isBST && (root.data > left.max && root.data < right.min)) {
            return new TreeInfo(Math.min(root.data, left.min), Math.max(root.data, right.max), left.size + 1 + right.size, true);
        }

        return new TreeInfo(0, 0, Math.max(left.size, right.size), false);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);

        root.left = new BinaryTree(15);
        root.right = new BinaryTree(8);

        root.left.left = new BinaryTree(12);
        root.left.right = new BinaryTree(20);
        root.right.left = new BinaryTree(5);
        root.right.right = new BinaryTree(9);

        root.left.left.left = new BinaryTree(2);
        root.left.left.right = new BinaryTree(14);
        root.right.left.left = new BinaryTree(4);
        root.right.left.right = new BinaryTree(7);

        root.right.right.right = new BinaryTree(10);

        System.out.println(findLargestBST(root).size);
    }
}
