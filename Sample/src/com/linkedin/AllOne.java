package com.linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.dec("hello");
        allOne.dec("hello");
        System.out.println(allOne.getMaxKey());
        allOne.inc("hello");
        System.out.println(allOne.getMinKey());
    }

    Map<String, Node> map;
    Node begin, end;

    public AllOne() {
        map = new HashMap<>();
        begin = new Node(0);
        end = new Node(0);
        begin.next = end;
        end.prev = begin;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            int freq = curr.freq;
            curr.keys.remove(key);
            Node next = curr.next;
            if (next == end || next.freq != freq+1) {
                Node newNode = new Node(freq+1);
                newNode.keys.add(key);
                newNode.prev = curr;
                curr.next = newNode;
                newNode.next = next;
                next.prev = newNode;
                map.put(key, newNode);
            } else {
                next.keys.add(key);
                map.put(key, next);
            }
            if (curr.keys.isEmpty()) {
                removeNode(curr);
            }
        } else {
            Node first = begin.next;
            if (first == end || first.freq > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.prev = begin;
                newNode.next = first;
                begin.next = newNode;
                first.prev = newNode;
                map.put(key, newNode);
            } else {
                first.keys.add(key);
                map.put(key, first);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node res = map.get(key);
        res.keys.remove(key);
        int freq = res.freq;
        if (freq == 1) {
            map.remove(key);
        } else {
            Node prev = res.prev;
            if (prev == begin || prev.freq != freq-1) {
                Node newNode = new Node(freq-1);
                newNode.keys.add(key);
                newNode.next = res;
                newNode.prev = prev;
                res.prev = newNode;
                prev.next = newNode;
                map.put(key, newNode);
            } else {
                prev.keys.add(key);
                map.put(key, prev);
            }
        }
        if (res.keys.isEmpty()) {
            removeNode(res);
        }
    }

    public String getMaxKey() {
        if (end.prev == begin) {
            return "";
        }
        return end.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (begin.next == end) {
            return "";
        }
        return begin.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

class Node {
    int freq;
    Set<String> keys;
    Node prev, next;

    Node(int freq) {
        this.freq = freq;
        keys = new HashSet<>();
    }
}
