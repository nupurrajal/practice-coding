package com.linkedin;

import com.practice.binarytree.BinaryTree;
import static com.practice.binarytree.Inorder.inorderRecursive;

public class LeavesToDLL {

    static BinaryTree dll = new BinaryTree(0);

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println("DLL front: ");
        dll = convertToDLL(root);
        BinaryTree end = null;
        while (dll != null) {
            System.out.print(dll.data + " ");
            end = dll;
            dll = dll.right;
        }
        System.out.println();
        System.out.println("DLL back: ");
        while (end != null) {
            System.out.print(end.data + " ");
            end = end.left;
        }
        System.out.println();
        System.out.println("Binary tree");
        inorderRecursive(root);
    }

    public static BinaryTree convertToDLL(BinaryTree root) {
        // Code here
        BinaryTree res = dll;
        convertToDLL1(root);
        res = res.right;
        res.left = null;
        return res;
    }

    private static BinaryTree convertToDLL1(BinaryTree root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            BinaryTree node = new BinaryTree(root.data);

            dll.right = node;
            node.left = dll;
            dll = dll.right;
            return null;
        }
        root.left = convertToDLL1(root.left);
        root.right = convertToDLL1(root.right);
        return root;
    }
}
