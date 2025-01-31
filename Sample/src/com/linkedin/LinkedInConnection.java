package com.linkedin;

import java.util.*;

public class LinkedInConnection {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        graph.put("Bob", Arrays.asList("Alice", "Eve", "Frank"));
        graph.put("Charlie", Arrays.asList("Alice", "Grace"));
        graph.put("David", Arrays.asList("Alice"));
        graph.put("Eve", Arrays.asList("Bob", "Henry"));
        graph.put("Frank", Arrays.asList("Bob"));
        graph.put("Grace", Arrays.asList("Charlie"));
        graph.put("Henry", Arrays.asList("Eve"));

        System.out.println(findConnectivity(graph, "Alice", "Henry")); // Output: "2nd degree"
        System.out.println(findConnectivity(graph, "Alice", "Grace")); // Output: "2nd degree"
        System.out.println(findConnectivity(graph, "Alice", "Zoe"));   // Output: "No connection"
    }

    private static String findConnectivity(Map<String, List<String>> graph, String person1, String person2) {
        if (person1.equals(person2)) {
            return "1st degree";
        }
        if (!graph.containsKey(person1) && !graph.containsKey(person2)) {
            return "No connection";
        }
        person1.indexOf(person2);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int degree = 1;
        queue.add(person1);
        while (!queue.isEmpty() || degree <= 3) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String neigh : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (neigh.equals(person2)) {
                         switch (degree) {
                            case 1: return "1st degree";
                            case 2: return "2nd degree";
                            case 3: return "3rd degree";
                        }
                    }
                    if (!visited.contains(neigh)) {
                        visited.add(neigh);
                        queue.add(neigh);
                    }
                }
            }
            degree++;
        }
        return "No connection";
    }
}
