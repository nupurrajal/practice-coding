package com.linkedin;

import com.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TODO: solve this using level order traversal as well

public class NAryToKAry {
    private final int k;
    public NAryToKAry(int k) {
        this.k = k;
    }

    public static void main(String[] args) {
        NAryToKAry obj = new NAryToKAry(3);
        TreeNode root = new TreeNode(1);

        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode child4 = new TreeNode(5);
        TreeNode child5 = new TreeNode(6);
        TreeNode child6 = new TreeNode(7);
        TreeNode child7 = new TreeNode(8);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        root.children.add(child4);
        root.children.add(child5);
        root.children.add(child6);
        root.children.add(child7);

        obj.convert(root, obj.k, new boolean[]{false});
        printTree(root);
    }

    private void convert(TreeNode root, int k, boolean[] flexibleAssigned) {
        if (root == null || root.children.isEmpty()) {
            return;
        }
        List<TreeNode> currGroup = new ArrayList<>();
        List<TreeNode> newChildren = new ArrayList<>();
        List<TreeNode> originalChildren = new ArrayList<>(root.children);

        for (TreeNode curr : originalChildren) {
            currGroup.add(curr);
            if (currGroup.size() == k) {
                TreeNode base = getBaseNode(currGroup);
                newChildren.add(base);
                currGroup.clear();
            }
        }
        if (!currGroup.isEmpty()) {
            if (!flexibleAssigned[0]) {
                newChildren.add(getBaseNode(currGroup));
                flexibleAssigned[0] = true;
            } else {
                newChildren.addAll(currGroup);
            }
        }
        root.children = newChildren;
        for (TreeNode child : newChildren) {
            if (child.val != -1) {
                convert(child, k, flexibleAssigned);
            }
        }
    }

    private TreeNode getBaseNode(List<TreeNode> children) {
        TreeNode curr = new TreeNode(-1);
        curr.children.addAll(children);
        return curr;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " -> ");
        for (TreeNode child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();
        for (TreeNode child : root.children) {
            printTree(child);
        }
    }
}
