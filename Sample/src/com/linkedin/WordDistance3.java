package com.linkedin;

public class WordDistance3 {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "makes", "perfect"};
        System.out.println(wordDistance3(words, "makes", "makes"));
    }

    private static int wordDistance3(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1, minDist = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (pos1 != -1) {
                        minDist = Math.min(minDist, i-pos1);
                    }
                    pos1 = i;
                }
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    pos1 = i;
                }
                if (words[i].equals(word2)) {
                    pos2 = i;
                }
                if (pos1 != -1 && pos2 != -1) {
                    minDist = Math.min(minDist, Math.abs(pos2 - pos1));
                }
            }
        }
        return minDist;
    }
}
