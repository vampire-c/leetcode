package leetcode.everyday;

import java.util.*;

class UnionFind {
    private final int[] fa;

    UnionFind(int n) {
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    public void merge(int from, int to) {
        int x = find(from);
        int y = find(to);
        fa[x] = y;
    }

    public void reset(int x) {
        fa[x] = x;
    }

}

class Solution2092 {

    public static void main(String[] args) {
        // new Solution2092().findAllPeople(6, new int[][]{{1, 5, 10}, {1, 2, 5}, {2, 3, 8}}, 1);
        new Solution2092().findAllPeople1(6, new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}}, 1);
    }


    public List<Integer> findAllPeople1(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        UnionFind uf = new UnionFind(n);
        uf.merge(firstPerson, 0);

        int m = meetings.length;
        for (int i = 0; i < m; ) {
            int start = i;
            int time = meetings[i][2];

            for (; i < m && meetings[i][2] == time; i++) {
                uf.merge(meetings[i][0], meetings[i][1]);
            }

            for (int j = start; j < i; j++) {
                int x = meetings[j][0];
                int y = meetings[j][1];
                if (!uf.isSame(x, 0)) {
                    uf.reset(x);
                }
                if (!uf.isSame(y, 0)) {
                    uf.reset(y);
                }
            }

        }

        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (uf.isSame(k, 0)) {
                ans.add(k);
            }
        }

        return ans;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        int m = meetings.length;
        for (int i = 0; i < m; ) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            int time = meetings[i][2];
            for (; i < m && meetings[i][2] == time; i++) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                g.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }
            Set<Integer> seen = new HashSet<>();
            for (int x : g.keySet()) {
                if (secret.contains(x) && !seen.contains(x)) {
                    dfs(x, g, seen, secret);
                }
            }

        }
        return secret.stream().toList();
    }

    private void dfs(int x, Map<Integer, List<Integer>> g, Set<Integer> seen, Set<Integer> secret) {
        seen.add(x);
        secret.add(x);
        for (Integer y : g.get(x)) {
            if (!seen.contains(y)) {
                dfs(y, g, seen, secret);
            }
        }
    }

}
