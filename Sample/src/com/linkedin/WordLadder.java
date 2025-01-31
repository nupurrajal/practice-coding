package com.linkedin;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        String begin = "hit";
        String end = "cog";
        System.out.println(getLadderLength(words, begin, end));
    }

    private static int getLadderLength(List<String> words, String begin, String end) {
        if (words.isEmpty()) {
            return 0;
        }
        if (!words.contains(end)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(words);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(begin);
        visited.add(begin);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(end)) {
                    return res;
                }
                for (int j = 0; j < currWord.length(); j++) {
                    char[] ch = currWord.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        ch[j] = k;
                        String modified = new String(ch);
                        if (wordSet.contains(modified) && !visited.contains(modified)) {
                             queue.add(modified);
                             visited.add(modified);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
