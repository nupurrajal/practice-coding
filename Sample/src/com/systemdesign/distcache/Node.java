package com.systemdesign.distcache;

public class Node {

    private final String key;
    private String value;

    private Node next, prev;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
