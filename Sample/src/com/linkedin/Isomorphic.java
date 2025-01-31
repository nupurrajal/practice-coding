package com.linkedin;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("fob", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sm = new HashMap();
        Map<Character, Character> tm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sm.containsKey(sc)) {
                if (sm.get(sc) != tc) {
                    return false;
                }
            } else {
                sm.put(sc, tc);
            }
            if (tm.containsKey(tc)) {
                if (tm.get(tc) != sc) {
                    return false;
                }
            } else {
                tm.put(tc, sc);
            }
        }
        return true;
    }
}
