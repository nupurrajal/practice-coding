package com.practice.binarytree;

import java.util.ArrayList;

public class SearchBST {

    /*
                    10
             -5             30
          -10   0               36
                   5
     */

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(-5);
        root.right = new BinaryTree(30);
        root.left.left = new BinaryTree(-10);
        root.left.right = new BinaryTree(0);
        root.right.right = new BinaryTree(36);
        root.left.right.right = new BinaryTree(5);
//        System.out.println(findKey(root, 35));
//        insertKey(root, 6);
        printZigZag(root);
    }


    private static boolean findKey(BinaryTree root, int i) {
        if (root == null)
            return false;
        if (root.data == i)
            return true;
        if (root.data < i) {
            return findKey(root.right, i);
        } else if (root.data > i) {
            return findKey(root.left, i);
        }
        return false;
    }

    private static BinaryTree insertKey(BinaryTree root, int key) {
        if (root == null)
            return new BinaryTree(key);
        if (key < root.data) {
            root.left = insertKey(root.left, key);
        } else {
            root.right = insertKey(root.right, key);
        }
        return root;
    }

    private static void printZigZag(BinaryTree root) {
        ArrayList<Integer> begin = new ArrayList<>();

        ArrayList<Integer> leftZigZag = printZigZag(root.left, false, begin);
        ArrayList<Integer> rightZigZag = printZigZag(root.right, true, begin);

//        begin.clear();
        ArrayList<Integer> begin1 = leftZigZag.size() > rightZigZag.size() ? (ArrayList<Integer>) leftZigZag.clone() : (ArrayList<Integer>) rightZigZag.clone();
        for (Integer i : begin1) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> printZigZag(BinaryTree root, boolean isRight, ArrayList<Integer> integers) {
        if (root == null) {
            return integers;
        }
        integers.add(root.data);
        if (isRight) {
            return printZigZag(root.left, false, integers);
        } else {
            return printZigZag(root.right, true, integers);
        }
    }


}
