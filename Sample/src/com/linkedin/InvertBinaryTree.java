package com.linkedin;

import com.practice.binarytree.BinaryTree;

import java.util.List;

import static com.practice.binarytree.ConstructBinaryTree.printLevelOrder;

public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        BinaryTree inverted = invertTree(root);
        List<List<Integer>> result = printLevelOrder(inverted);
        for (List<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static BinaryTree invertTree(BinaryTree root) {
        if (root == null || root.left == null) {
            return root;
        }
        // this is actually root's left
        BinaryTree newNode = invertTree(root.left);
        // root's left now the main root - here left will be original root's right
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newNode;
    }


}
