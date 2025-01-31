package com.linkedin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length+1];
        Map<Integer, Integer> fMap = new HashMap();
        for (int i : nums) {
            fMap.put(i, fMap.getOrDefault(i, 0) + 1);
        }
        for (Integer i : fMap.keySet()) {

        }
        int[] top = new int[k];
        for (int i = k-1; i >= 0; i--) {
//            top[i] ;
        }
        return top;
    }
}
