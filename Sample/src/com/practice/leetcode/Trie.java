package com.practice.leetcode;

class TrieNode {
    TrieNode[] listOfChars;
    boolean isEnd;

    TrieNode () {
        this.listOfChars = new TrieNode[26];
    }

    public boolean hasKey(char c) {
        return listOfChars[c -'a'] != null;
    }

    public void putKey(TrieNode node, char c) {
        listOfChars[c-'a'] = node;
    }

    public TrieNode get(char c) {
        return this.listOfChars[c - 'a'];
    }
}

public class Trie {

    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (Character c : word.toCharArray()) {
            if (!curr.hasKey(c)) {
                curr.putKey(curr, c);
            }
            curr = curr.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = searchPrefix(word);
        return curr != null && curr.isEnd;
    }

    public boolean startsWith(String word) {
        TrieNode curr = searchPrefix(word);
        return curr != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (Character c : prefix.toCharArray()) {
            if (!curr.hasKey(c)) {
                curr.putKey(curr, c);
            }
            else {
                return null;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("nupur");
        trie.insert("sarthak");
        System.out.println(trie.startsWith("nup"));
        System.out.println(trie.search("sarthak"));
    }
}
