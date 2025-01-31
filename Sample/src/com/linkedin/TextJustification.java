package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = justify(words, 16);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> justify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int currWidth = 0;
        for (String word : words) {
            if (currWidth + word.length() > maxWidth) {
                lines.add(justifiedLineUtil(currLine, currWidth, maxWidth));
                currLine = new ArrayList<>();
                currWidth = 0;
            }
            currLine.add(word);
            currWidth += word.length() + 1;
        }
        if (!currLine.isEmpty()) {
            lines.add(leftJustifyUtil(currLine, maxWidth));
        }
        return lines;
    }

    private static String leftJustifyUtil(List<String> currLine, int maxWidth) {
        String result = String.join(" ", currLine);
        return result + " ".repeat(maxWidth-result.length());
    }

    private static String justifiedLineUtil(List<String> currLine, int currWidth, int maxWidth) {
        StringBuilder result = new StringBuilder();
        if (currLine.size() == 1) {
            return currLine.get(0) + " ".repeat(maxWidth- currLine.get(0).length());
        }
        int totalChars = currWidth - currLine.size();
        int spaceSlots = currLine.size()-1;
        int spacePerSlot = (maxWidth - totalChars) / spaceSlots;
        int extraSpacePerSlot = (maxWidth - totalChars) % spaceSlots;
        for (int i = 0; i < currLine.size(); i++) {
            result.append(currLine.get(i));
            if (i < spaceSlots) {
                result.append(" ".repeat(spacePerSlot));
                if (extraSpacePerSlot > 0) {
                    result.append(" ");
                    extraSpacePerSlot--;
                }
            }
        }
        return result.toString();
    }
}
