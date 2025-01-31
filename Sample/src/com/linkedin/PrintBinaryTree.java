package com.linkedin;

import com.practice.binarytree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

    public List<List<String>> printTree(BinaryTree root) {
        List<List<String>> res = new ArrayList();
        int height = getHeight(root) + 1;
        int col = (int) Math.pow(2, height) - 1;
        for(int k = 0; k < height; k++){
            List<String> list = new ArrayList();
            for(int i = 0; i < col; i++){
                list.add("");
            }
            res.add(list);
        }
        printTree(root, 0, col-1, 0, res);
        return res;
    }

    private void printTree(BinaryTree root, int left, int right, int level, List<List<String>> res) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res.get(level).set(mid, String.valueOf(root.data));
        printTree(root.left, left, mid-1, level+1, res);
        printTree(root.right, mid+1, right, level+1, res);
    }

    public int getHeight(BinaryTree root){
        if (root==null) return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right)+1;
    }
}
