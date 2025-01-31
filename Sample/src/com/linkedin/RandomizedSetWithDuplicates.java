package com.linkedin;

import java.util.*;

public class RandomizedSetWithDuplicates {
    List<Integer> list;
    Map<Integer, Set<Integer>> indexMap;
    Random random;

    public RandomizedSetWithDuplicates() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        list.add(val);
        indexMap.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size()-1);
        return indexMap.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val) || indexMap.get(val).isEmpty()) {
            return false;
        }
        int removeIdx = indexMap.get(val).iterator().next();
        indexMap.get(val).remove(removeIdx);

        int lastVal = list.get(list.size()-1);
        list.set(removeIdx, lastVal);
        indexMap.get(lastVal).add(removeIdx);
        indexMap.get(lastVal).remove(list.size()-1);

        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSetWithDuplicates randomSet = new RandomizedSetWithDuplicates();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());
    }
}
