package com.linkedin;

import java.util.*;

public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));
        System.out.println(r.remove(2));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
        System.out.println(r.remove(1));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
    }

    Random random;
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int end = list.get(index);
        list.set(index, end);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
