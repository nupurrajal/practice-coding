package com.linkedin;

import com.practice.tree.TreeNode;

import java.util.*;

public class DeleteLeavesOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode subChild1 = new TreeNode(4);
        child1.children.add(new TreeNode(7));
        TreeNode subSubChild1 = new TreeNode(8);
        subChild1.children.add(subSubChild1);
        child1.children.add(subChild1);
        root.children.add(child1);

        TreeNode child2 = new TreeNode(5);
        TreeNode subChild2 = new TreeNode(9);
        child2.children.add(subChild2);
        root.children.add(child2);
        root.children.add(new TreeNode(3));

        Map<Integer, List<Integer>> result = new HashMap<>();
        leafNodesOnSameLevelPrac(root, result);
        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            for (Integer i : entry.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
//        System.out.println("Level order");
//        Map<Integer, Integer> parentChildMap = new HashMap<>();
//        Map<Integer, Integer> childrenMap = new HashMap<>();
//        List<Integer> resultQueue = new ArrayList<>();
//        leafNodesOnSameLevelQueue(root, parentChildMap, childrenMap, resultQueue);
//        for (int i : resultQueue) {
//            System.out.print(i + " ");
//        }
    }

    private static int leafNodesOnSameLevelPrac(TreeNode root, Map<Integer, List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            maxHeight = Math.max(maxHeight, leafNodesOnSameLevelPrac(root.children.get(i), result));
        }
        result.computeIfAbsent(maxHeight, k -> new ArrayList<>()).add(root.val);
        return maxHeight+1;
    }


    private static int leafNodesOnSameLevel(TreeNode root, Map<Integer, List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            maxHeight = Math.max(maxHeight, leafNodesOnSameLevel(root.children.get(i), result));
        }
        List<Integer> curr = result.getOrDefault(maxHeight, new ArrayList<>());
        curr.add(root.val);
        result.put(maxHeight, curr);
        return maxHeight+1;
    }

    private static void leafNodesOnSameLevelQueue(TreeNode root, Map<Integer, Integer> parentChildMap,
                                                 Map<Integer, Integer> childrenMap, List<Integer> result) {
        if (root == null) {
            return;
        }
        buildChildrenParentMap(root, parentChildMap, childrenMap);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> i : childrenMap.entrySet()) {
            if (i.getValue() == 0) {
                queue.offer(i.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int leaveNode = queue.poll();
                result.add(leaveNode);
                if (parentChildMap.containsKey(leaveNode)) {
                    int parent = parentChildMap.get(leaveNode);
                    childrenMap.put(parent, childrenMap.get(parent)-1);
                    if (childrenMap.get(parent) == 0) {
                        queue.offer(parent);
                    }
                }
            }
        }
    }

    private static void buildChildrenParentMap(TreeNode root, Map<Integer, Integer> parentChildMap,
                                               Map<Integer, Integer> childrenMap) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            childrenMap.put(curr.val, curr.children.size());
            for (TreeNode child : curr.children) {
                parentChildMap.put(child.val, curr.val);
                queue.offer(child);
            }
        }
    }
}
