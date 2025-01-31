package com.linkedin;

import java.util.*;

public class MergeAccounts {

    private static Map<String, List<String>> adjacent;
    private static HashSet<String> visited;

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = mergeEmailAccountsDSU(accounts);
        for (List<String> currAcc : mergedAccounts) {
            for (String curr : currAcc) {
                System.out.print(curr + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> mergeEmailAccounts(List<List<String>> accounts) {
        adjacent = new HashMap<String, List<String>>();
        for (List<String> currAccount : accounts) {
            int size = currAccount.size();
            String firstMail = currAccount.get(1);
            for (int j = 2; j < size; j++) {
                adjacent.computeIfAbsent(firstMail, k -> new ArrayList<>()).add(currAccount.get(j));
                adjacent.computeIfAbsent(currAccount.get(j), k -> new ArrayList<>()).add(firstMail);
            }
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        visited = new HashSet<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                List<String> currMergedAccount = new ArrayList<>();
                currMergedAccount.add(name);
                dfsUtility(currMergedAccount, firstEmail);
                Collections.sort(currMergedAccount.subList(1, currMergedAccount.size()));
                mergedAccounts.add(currMergedAccount);
            }
        }
        return mergedAccounts;
    }

    private static void dfsUtility(List<String> currMergedAccount, String firstEmail) {
        visited.add(firstEmail);
        currMergedAccount.add(firstEmail);
        if (!adjacent.containsKey(firstEmail)) {
            return;
        }
        for (String sameMail : adjacent.get(firstEmail)) {
            if (!visited.contains(sameMail)) {
                dfsUtility(currMergedAccount, sameMail);
            }
        }
    }

    private static List<List<String>> mergeEmailAccountsDSU(List<List<String>> accounts) {
        adjacent = new HashMap<>();
        int size = accounts.size();
        DSU dsu = new DSU(size);
        // for every mail, store the group
        /*
        emailGroup - {
                        {johnsmith@mail.com, 0},
                        {}
                     }
         */
        Map<String, Integer> emailGroup = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int accSize = accounts.get(i).size();
            for (int j = 1; j < accSize; j++) {
                String email = accounts.get(i).get(j);
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    dsu.union(i, emailGroup.get(email));
                }
            }
        }

        // store the components together now that union has been done
        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int rep = dsu.findParent(group);
            components.computeIfAbsent(rep, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> emails = components.get(group);
            emails.add(0, accounts.get(group).get(0));
            mergedAccounts.add(emails);
        }
        return mergedAccounts;
    }
}

class DSU {
    int[] size;
    int[] representative;

    DSU(int sz) {
        representative = new int[sz];
        size = new int[sz];

        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
            representative[i] = i;
            // Intialise the size of all groups to 1
            size[i] = 1;
        }
    }

    public int findParent(int x) {
        if (x == representative[x]) {
            return x;
        }
        return representative[x] = findParent(representative[x]);
    }

    public void union(int x, int y) {
        int rx = findParent(x);
        int ry = findParent(y);
        if (rx == ry) {
            return;
        }
        if (size[x] >= size[y]) {
            representative[y] = x;
            size[x] += size[y];
        } else {
            representative[x] = y;
            size[y] += size[x];
        }
    }
}
