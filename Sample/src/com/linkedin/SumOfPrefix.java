package com.linkedin;

public class SumOfPrefix {
    static Trie root = new Trie();

    public static void main(String[] args) {
//        String[] words = {"a", "ab", "abc", "cab"};
        String[] words = {"abc","ab","bc","b"};
        int[] result = sumPrefixScores(words);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < words.length; i++) {
            result[i] = search(words[i]);
        }
        return result;
    }

    private static void insert(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.hasKey(c)) {
                curr.put(c, new Trie());
            }
            curr.increment(c);
            curr = curr.get(c);
        }
    }

    // get prefix count
    private static int search(String word) {
        Trie curr = root;
        int prefixCount = 0;
        for (char c : word.toCharArray()) {
            prefixCount += curr.getCount(c);
            curr = curr.get(c);
        }
        return prefixCount;
    }
}

class Trie {
    Trie[] listOfChars;
    int freq;

    Trie () {
        this.listOfChars = new Trie[26];
    }

    boolean hasKey(char c) {
        return listOfChars[c-'a'] != null;
    }

    void put(char c, Trie node) {
        listOfChars[c-'a'] = node;

    }

    Trie get(char c) {
        return listOfChars[c-'a'];
    }

    void increment(char c) {
        listOfChars[c-'a'].freq++;
    }

    int getCount(char c) {
        return listOfChars[c-'a'].freq;
    }
}