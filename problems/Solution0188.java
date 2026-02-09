package leetcode.problems;

import java.util.Arrays;

public class Solution0188 {

    public static void main(String[] args) {
        new f1();
        new f2();
        new f3();
    }

    static class f3 {
        public f3() {
            int maxProfit = maxProfit(2, new int[]{2, 4, 1});
            System.out.println(maxProfit);
        }

        public int maxProfit(int k, int[] prices) {
            int[][] f = new int[k + 2][2];
            for (int j = 1; j <= k + 1; j++) {
                f[j][1] = Integer.MIN_VALUE / 2;
            }
            f[0][0] = Integer.MIN_VALUE / 2;
            for (int p : prices) {
                for (int j = k + 1; j > 0; j--) {
                    f[j][0] = Math.max(f[j][0], f[j][1] + p);
                    f[j][1] = Math.max(f[j][1], f[j - 1][0] - p);
                }
            }
            return f[k + 1][0];
        }

    }


    static class f2 {
        public f2() {
            int maxProfit = maxProfit(2, new int[]{2, 4, 1});
            System.out.println(maxProfit);
        }

        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] f = new int[n + 1][k + 2][2];
            for (int[][] mat : f) {
                for (int[] row : mat) {
                    Arrays.fill(row, Integer.MIN_VALUE / 2);
                }
            }
            for (int j = 1; j < k + 1; j++) {
                f[0][j][0] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < k + 1; j++) {
                    f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                    f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j - 1][0] - prices[i]);
                }
            }
            return f[n][k + 1][0];
        }


    }


    static class f1 {
        public f1() {
            int maxProfit = maxProfit(2, new int[]{2, 4, 1});
            System.out.println(maxProfit);
        }

        private int[] prices;
        private int[][][] memo;

        public int maxProfit(int k, int[] prices) {
            this.prices = prices;
            int n = prices.length;
            memo = new int[n][k + 1][2];
            for (int[][] mat : memo) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }
            return dfs(n - 1, k, 0);
        }

        private int dfs(int i, int j, int hold) {
            if (j < 0) return Integer.MIN_VALUE / 2;
            if (i < 0) return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
            if (memo[i][j][hold] != -1) return memo[i][j][hold];
            if (hold == 1) return memo[i][j][hold] = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - prices[i]);
            return memo[i][j][hold] = Math.max(dfs(i - 1, j, 0), dfs(i - 1, j, 1) + prices[i]);
        }
    }


}
