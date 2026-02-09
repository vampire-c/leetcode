package leetcode.problems;

import java.util.Arrays;

class Solution2976 {

    static void main(String[] args) {
        new Solution2976().minimumCost(
                "abcd",
                "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}
        );
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            dis[x][y] = Math.min(dis[x][y], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dis[i][k] == INF) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int d = dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (d == INF) {
                return -1;
            }
            ans += d;
        }
        return ans;
    }

}
