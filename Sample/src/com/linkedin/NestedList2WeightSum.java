package com.linkedin;

import java.util.Arrays;
import java.util.List;

public class NestedList2WeightSum {
    public static void main(String[] args) {
        List<NestedInteger> nestedList1 = Arrays.asList(
                new NestedIntegerImpl(Arrays.asList(
                        new NestedIntegerImpl(1),
                        new NestedIntegerImpl(1)
                )),
                new NestedIntegerImpl(2),
                new NestedIntegerImpl(Arrays.asList(
                        new NestedIntegerImpl(1),
                        new NestedIntegerImpl(1)
                ))
        );

        System.out.println(getDepthSum(nestedList1));
    }

    private static int getDepthSum(List<NestedInteger> list) {
        return getDepthSum(list, 1);
    }

    private static int getDepthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger curr : list) {
            if (curr.isInteger()) {
                sum += curr.getInteger() * depth;
            } else {
                sum += getDepthSum(curr.getList(), depth+1);
            }
        }
        return sum;
    }
}

interface NestedInteger {
    // Returns true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // Returns the single integer that this NestedInteger holds, if it holds a single integer.
    // Returns null if this NestedInteger holds a nested list.
    Integer getInteger();

    // Returns the nested list that this NestedInteger holds, if it holds a nested list.
    // Returns an empty list if this NestedInteger holds a single integer.
    List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor for single integer
    public NestedIntegerImpl(int value) {
        this.value = value;
        this.list = null;
    }

    // Constructor for nested list
    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
        this.value = null;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}