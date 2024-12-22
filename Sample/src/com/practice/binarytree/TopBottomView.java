package com.practice.binarytree;

import com.practice.utils.Pair;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        topView(root);
        System.out.println();
        bottomView(root);
    }

    private static void topView(BinaryTree root) {
        if (root == null) {
            return;
        }
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(Pair.of(root, 0));
        while (!queue.isEmpty()) {
            int m = queue.size();
            while (m-- > 0) {
                Pair<BinaryTree, Integer> curr = queue.poll();
                BinaryTree currNode = curr.getFirst();
                int row = curr.getSecond();
                if (!map.containsKey(row)) {
                    map.put(row, currNode.data);
                }
                if (currNode.left != null) {
                    queue.offer(Pair.of(currNode.left, row-1));
                }
                if (currNode.right != null) {
                    queue.offer(Pair.of(currNode.right, row+1));
                }
            }
        }
        for (Map.Entry<Integer, Integer> values : map.entrySet()) {
            System.out.print(values.getValue() + " ");
        }
    }

    private static void bottomView(BinaryTree root) {
        if (root == null) {
            return;
        }
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(Pair.of(root, 0));
        while (!queue.isEmpty()) {
            int m = queue.size();
            while (m-- > 0) {
                Pair<BinaryTree, Integer> curr = queue.poll();
                BinaryTree currNode = curr.getFirst();
                int row = curr.getSecond();
                map.put(row, currNode.data);

                if (currNode.left != null) {
                    queue.offer(Pair.of(currNode.left, row-1));
                }
                if (currNode.right != null) {
                    queue.offer(Pair.of(currNode.right, row+1));
                }
            }
        }
        for (Map.Entry<Integer, Integer> values : map.entrySet()) {
            System.out.print(values.getValue() + " ");
        }
    }
}
