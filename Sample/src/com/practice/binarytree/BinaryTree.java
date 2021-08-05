package com.practice.binarytree;

import java.util.Objects;

public class BinaryTree {
    int data;
    BinaryTree left, right;

    BinaryTree(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return data == that.data && Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }

    public BinaryTree getRandom() {

        return new BinaryTree(1);
    }
}
