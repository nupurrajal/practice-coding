package com.practice.binarytree;

import java.util.*;

public class BurnTree {

    private static Queue<BinaryTree> queue = new LinkedList<>();
    private static List<List<Integer>> burntSequence = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(3);
        root.left = new BinaryTree(5);
        root.right = new BinaryTree(1);
        root.left.left = new BinaryTree(6);
        root.left.right = new BinaryTree(2);
        root.right.left = new BinaryTree(0);
        root.right.right = new BinaryTree(8);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(4);

        int num = 2;
        HashMap<Integer, Set<Integer>> levelOrderMap = new HashMap<>();
        search(root, num, levelOrderMap);

        System.out.println(num);
        for (Integer level : levelOrderMap.keySet())
        {
            for (Integer val : levelOrderMap.get(level))
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }

//        burnBT(root, 2);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> tempList = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                BinaryTree curr = queue.poll();
//                tempList.add(curr.data);
//                if (curr.left != null) {
//                    queue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    queue.offer(curr.right);
//                }
//            }
//            burntSequence.add(tempList);
//        }
//        for (List<Integer> temp : burntSequence) {
//            for (int curr : temp) {
//                System.out.print(curr + " ");
//            }
//            System.out.println();
//        }
    }

    private static int burnBT(BinaryTree root, int target) {
        if (root == null) {
            return 0;
        }
        if (root.data == target) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.data);
            burntSequence.add(temp);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            return 1;
        }
        int left = burnBT(root.left, target);
        if (left == 1) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTree curr = queue.poll();
                temp.add(curr.data);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            temp.add(root.data);
            burntSequence.add(temp);
            return 1;
        }
        int right = burnBT(root.right, target);
        if (right == 1) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTree curr = queue.poll();
                temp.add(curr.data);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            temp.add(root.data);
            burntSequence.add(temp);
            return 1;
        }
        return 0;
    }

    // gfg
    public static int search(BinaryTree root, int num, Map<Integer, Set<Integer>> levelOrderMap) {
        if (root == null) {
            return -1;
        }
        // Condition to check whether target node is found or not in a tree
        if (root.data == num) {
            levelOrderStoredInMap(root.left, 1, levelOrderMap);
            levelOrderStoredInMap(root.right, 1, levelOrderMap);
            // Return statements to prevent further function calls
            return 1;
        }
        int k = search(root.left, num, levelOrderMap);
        if (k > 0) {
            // store root in map with k
            storeRootAtK(root, k, levelOrderMap);
            // store level order for other branch
            levelOrderStoredInMap(root.right, k + 1, levelOrderMap);
            return k + 1;
        }
        k = search(root.right, num, levelOrderMap);
        if (k > 0) {
            // store root in map with k
            storeRootAtK(root, k, levelOrderMap);
            // store level order for other branch
            levelOrderStoredInMap(root.left, k + 1, levelOrderMap);
            return k + 1;
        }
        return -1;
    }

    public static void levelOrderStoredInMap(BinaryTree root, int k, Map<Integer, Set<Integer>> levelOrderMap)
    {
        if (root != null) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1,
                    levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1,
                    levelOrderMap);
        }
    }

    private static void storeRootAtK(BinaryTree root, int k, Map<Integer, Set<Integer> > levelOrderMap)
    {
        if (levelOrderMap.containsKey(k)) {
            levelOrderMap.get(k).add(root.data);
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(root.data);
            levelOrderMap.put(k, set);
        }
    }
}
