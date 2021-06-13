package com.practice.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        ArrayList<Integer> result = printInorderIterative(root);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> printInorderIterative(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.data);
            root = root.right;
        }
        return result;
    }
}
