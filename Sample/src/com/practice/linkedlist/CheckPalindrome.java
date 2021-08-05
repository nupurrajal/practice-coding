package com.practice.linkedlist;

public class CheckPalindrome {

    private static Node left, head;

    public static void main(String[] args) {
        Node root = new Node(3);
        root.next = new Node(1);
        root.next.next = new Node(5);
        root.next.next.next = new Node(6);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(2);
        root.next.next.next.next.next.next = new Node(3);
        head = root;
        System.out.println(isPalindrome(root));
    }

    private static boolean isPalindrome(Node root) {
        if (root == null) {
            return true;
        }
        left = head;
        boolean checkNext = isPalindrome(root.next);
        if (!checkNext) {
            return false;
        }
        Node temp = left;
        left = left.next;
        return root.val == temp.val;
    }
}
