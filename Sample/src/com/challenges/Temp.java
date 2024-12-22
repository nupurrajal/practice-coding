package com.challenges;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Temp {

    public static void main(String[] args) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                if (Objects.equals(m1.getValue(), m2.getValue())) {
                    return m1.getKey().compareTo(m2.getKey());
                }
                return m2.getValue() - m1.getValue();
            }
        });
    }
}
