package com.linkedin;

import com.practice.linkedlist.ListNode;

public class RotateRightByKPlaces {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 7;
        ListNode rotated = getRotatedList(head, k);
        while (rotated != null) {
            System.out.print(rotated.val + " ");
            rotated = rotated.next;
        }
    }

    private static ListNode getRotatedList(ListNode head, int k) {
        ListNode temp = new ListNode(-1), fast = temp, slow = temp;
        temp.next = head;
        int len = 0;
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }
        if (len == 0) {
            return null;
        }
        k %= len;
        for (int i = 0; i < len-k; i++) {
            slow = slow.next;
        }
        fast.next = temp.next;
        temp.next = slow.next;
        slow.next = null;
        return temp.next;
    }
}
