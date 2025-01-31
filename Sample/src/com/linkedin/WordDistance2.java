package com.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance2 {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        System.out.println(getDistanceBetweenWordsMap(words, word1, word2));
    }

    private static int getDistanceBetweenWords(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int p1 = -1, p2 = -1;
        int i = 0;
        while (i < words.length) {
            boolean changed = false;
            String currWord = words[i];
            if (currWord.equals(word1)) {
                p1 = i;
                changed = true;
            } else if (currWord.equals(word2)) {
                p2 = i;
                changed = true;
            }
            if (changed && p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1-p2));
            }
            i++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int getDistanceBetweenWordsMap(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        Map<String, List<Integer>> indicesMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            indicesMap.computeIfAbsent(words[i], k -> new ArrayList()).add(i);
        }
        if (!indicesMap.containsKey(word1) || !indicesMap.containsKey(word2)) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int w1 = 0, w2 = 0;
        List<Integer> l1 = indicesMap.get(word1);
        List<Integer> l2 = indicesMap.get(word2);
        while (w1 < l1.size() && w2 < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(w1) - l2.get(w2)));
            if (l1.get(w1) > l2.get(w2)) {
                w2++;
            } else {
                w1++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
