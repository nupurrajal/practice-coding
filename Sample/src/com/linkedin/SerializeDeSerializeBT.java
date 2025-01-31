package com.linkedin;

import com.practice.binarytree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerializeBT {

    public ArrayList<Integer> serialize(BinaryTree root) {
        // code here
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<Integer> result = new ArrayList();
        Queue<BinaryTree> queue = new LinkedList();
        queue.offer(root);
        result.add(root.data);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    result.add(curr.left.data);
                } else {
                    result.add(-1);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    result.add(curr.right.data);
                } else {
                    result.add(-1);
                }
            }
        }
        return result;
    }

    // Function to deserialize a list and construct the tree.
    public BinaryTree deSerialize(ArrayList<Integer> A) {
        // code here
        if (A.size() == 0) {
            return null;
        }
        BinaryTree root = new BinaryTree(A.get(0));
        Queue<BinaryTree> queue = new LinkedList();
        queue.offer(root);
        for (int i = 1; i < A.size(); i++) {
            BinaryTree curr = queue.poll();
            if (A.get(i) != -1) {
                curr.left = new BinaryTree(A.get(i));
                queue.offer(curr.left);
            }
            if (A.get(++i) != -1) {
                curr.right = new BinaryTree(A.get(i));
                queue.offer(curr.right);
            }
        }
        return root;
    }
}
