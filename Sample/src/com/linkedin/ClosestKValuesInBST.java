package com.linkedin;

import com.practice.binarytree.BinaryTree;

import java.util.*;

import static com.practice.binarytree.Inorder.printInorderIterative;

public class ClosestKValuesInBST {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(4);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(5);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);

        double target = 3.714286;
        int k = 3;

        List<Integer> result = getKClosestValueInBSTDeque(root, target, k);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> getKClosestValueInBSTDeque(BinaryTree root, double target, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        getKClosestValueInBSTDequeUtil(root, deque, target, k);
        return new ArrayList<>(deque);
    }

    private static void getKClosestValueInBSTDequeUtil(BinaryTree root, Deque<Integer> deque, double target, int k) {
        if (root == null) {
            return;
        }
        getKClosestValueInBSTDequeUtil(root.left, deque, target, k);
        if (deque.size() < k) {
            deque.addLast(root.data);
        } else {
            if (Math.abs(target-root.data) < Math.abs(target-deque.peekFirst())) {
                deque.pollFirst();
                deque.addLast(root.data);
            } else {
                return;
            }
        }
        getKClosestValueInBSTDequeUtil(root.right, deque, target, k);
    }

    private static List<Double> getKClosestValueInBSTHeap(BinaryTree root, double target, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>(k,
                (o1, o2) -> Double.compare(Math.abs(o2-target), Math.abs(o1-target)));

        List<Integer> inorder = printInorderIterative(root);
        for (int i : inorder) {
            pq.add((double) i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}
