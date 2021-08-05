package com.practice.linkedlist;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.next = new Node(6);
        root.next.next = new Node(5);
        root.next.next.next = new Node(6);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(5);
        root.next.next.next.next.next.next = new Node(2);
        root.next.next.next.next.next.next.next = new Node(1);

        removeDuplicates(root);

        printLL(root);
    }

    private static void removeDuplicates(Node root) {
        Node temp = root;
        while (temp != null) {
            Node next = temp.next;
            Node prev = temp;
            while (next != null) {
                if (next.val == temp.val) {
                    prev.next = next.next;
                    next = prev;
                }
                prev = next;
                next = next.next;
            }
            temp = temp.next;
        }
    }

    private static void printLL(Node root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
