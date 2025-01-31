package com.linkedin;

import java.util.HashSet;
import java.util.Set;

public class LCA3 {

    public static void main(String[] args) {

    }

    public BTNode getLCA2Pointers(BTNode p, BTNode q) {
        BTNode a = p, b = q;

        // Traverse upwards until they meet
        while (a != b) {
            // If a reaches null (root's parent), reset to q
            a = (a == null) ? q : a.parent;

            // If b reaches null (root's parent), reset to p
            b = (b == null) ? p : b.parent;
        }

        // Both pointers meet at LCA
        return a;
    }

    private static BTNode getLCA(BTNode p, BTNode q) {
        Set<BTNode> pPath = getPath(p, new HashSet<>());
        Set<BTNode> qPath = getPath(q, new HashSet<>());
        for (BTNode pp : pPath) {
            if (qPath.contains(pp)) {
                return pp;
            }
        }
        return null;
    }

    private static Set<BTNode> getPath(BTNode p, Set<BTNode> pPath) {
        if (p == null) {
            return pPath;
        }
        pPath.add(p);
        return getPath(p.parent, pPath);
    }
}

class BTNode {
    BTNode parent, left, right;
    int value;

    BTNode(int value, BTNode parent) {
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}
