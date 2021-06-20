package com.practice.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    static List<List<Integer>> result = new ArrayList();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        pathSum(root, targetSum, new ArrayList());
        pathSum(root, targetSum, 0, new ArrayList());
        return result;
    }

    private static void pathSum(TreeNode root, int targetSum, List<Integer> currList) {
        if (root == null) {
            return;
        }
        currList.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(currList));
            }
        }
        pathSum(root.left, targetSum - root.val, currList);
        pathSum(root.right, targetSum - root.val, currList);
        currList.remove(currList.size() - 1);
    }

    private static void pathSum(TreeNode root, int targetSum, int currSum, List<Integer> currList) {
        if (root == null) {
            return;
        }
        currList.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(currList));
            }
        }
        pathSum(root.left, targetSum, currSum, currList);
        pathSum(root.right, targetSum, currSum, currList);
        currList.remove(currList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;
        List<List<Integer>> res = pathSum(root, target);
        for (List<Integer> curr : res) {
            for (Integer i : curr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
