package com.linkedin;

import com.practice.binarytree.BinaryTree;
import java.util.*;
import static com.practice.binarytree.Inorder.printInorderIterative;

public class BTFromParentChild {
    public static void main(String[] args) {
        List<Relation> relationList = new ArrayList<>();
        relationList.add(new Relation(20,15,true));
        relationList.add(new Relation(80,19,true));
        relationList.add(new Relation(20,17,false));
        relationList.add(new Relation(80,16,false));
        relationList.add(new Relation(50,80,false));
        relationList.add(new Relation(null,50,false));
        relationList.add(new Relation(50,20,true));

        BinaryTree root = formBinaryTreeFromRelation(relationList);
        ArrayList<Integer> result = printInorderIterative(root);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static BinaryTree formBinaryTreeFromRelation(List<Relation> relationList) {
        Map<Integer, Integer> childToParent = new HashMap<>();
        Map<Integer, Boolean> childToSide = new HashMap<>();
        BinaryTree root = null;
        for (Relation r : relationList) {
            if (r.parent != null) {
                childToParent.put(r.child, r.parent);
                childToSide.put(r.child, r.isLeft);
            }
            if (r.parent == null) {
                root = new BinaryTree(r.child);
            }
        }
        Map<Integer, BinaryTree> nodeMap = new HashMap<>();
        if (root != null) {
            buildTree(root, nodeMap, childToSide, childToParent);
        }
        return root;
    }

    private static void buildTree(BinaryTree root, Map<Integer, BinaryTree> nodeMap, Map<Integer, Boolean> childToSide, Map<Integer, Integer> childToParent) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree curr = queue.poll();
            for (Map.Entry<Integer, Integer> entry : childToParent.entrySet()) {
                int child = entry.getKey(), parent = entry.getValue();
                if (curr.data == parent) {
                    BinaryTree childNode = nodeMap.getOrDefault(child, new BinaryTree(child));
                    nodeMap.put(child, childNode);
                    if (childToSide.get(child)) {
                        curr.left = childNode;
                    } else {
                        curr.right = childNode;
                    }
                    queue.offer(childNode);
                }
            }
        }
    }
}

class Relation {
    Integer parent;
    Integer child;
    boolean isLeft;

    public Relation(Integer parent, Integer child, boolean isLeft) {
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }
}
