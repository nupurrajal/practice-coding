package com.challenges;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int value;
    List<Node> nodes;

    Node(int value) {
        this.value = value;
        nodes = new ArrayList<>();
    }
}


class Result {

    /*
     * Complete the 'minimumGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY predators as parameter.
     */

    public static int minimumGroups(List<Integer> predators) {
        // Write your code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < predators.size(); i++) {
            ArrayList<Integer> value = new ArrayList<>();
            if (map.containsKey(predators.get(i))) {
                value = map.get(predators.get(i));
            }
            value.add(i);
            map.put(predators.get(i), value);
        }
        List<Integer> sups = map.get(-1);
        map.remove(-1);
        List<Node> roots = new ArrayList<>();
        for (Integer i : sups) {
            Node root = new Node(i);
            constructTree(root, map);
            roots.add(root);
        }
        int max = 0;
        for (Node root : roots) {
            int height = getHeight(root);
            max = Math.max(max, height);
        }
        return max;
    }

    private static int getHeight (Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (Node curr : root.nodes) {
            max = Math.max(max, 1+getHeight(curr));
        }
        return max;
    }

    private static void constructTree (Node root, Map<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;

        int val = root.value;

        if (map.containsKey(val)) {
            List<Integer> keys = map.get(val);
            for (Integer key : keys) {
                Node temp = new Node(key);
                root.nodes.add(temp);
            }
        }
        for (Node node : root.nodes) {
            constructTree(node, map);
        }
    }
}

public class ArrToTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int predatorsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> predators = new ArrayList<>();

        for (int i = 0; i < predatorsCount; i++) {
            int predatorsItem = Integer.parseInt(bufferedReader.readLine().trim());
            predators.add(predatorsItem);
        }

        int result = Result.minimumGroups(predators);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}