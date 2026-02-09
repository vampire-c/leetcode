package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution0494 {

    public static void main(String[] args) {
        new f1_1();
        new f1_2();
        new f2();
        new f3();
        new f4();
    }

    static class f4 {
        f4() {
            int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
            System.out.println(targetSumWays);
        }

        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int s = 0;
            for (int i : nums) {
                s += Math.abs(i);
            }
            if (target > s || (s - target) % 2 != 0) {
                return 0;
            }
            int m = (s - target) / 2;
            int[][] f = new int[n + 1][m + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = 0; j <= m; j++) {
                    f[i][j] += f[i - 1][j];
                    if (j >= x) {
                        f[i][j] += f[i - 1][j - x];
                    }
                }
            }
            return f[n][m];
        }

    }

    static class f3 {
        f3() {
            int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
            System.out.println(targetSumWays);
        }

        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int s = 0;
            for (int i : nums) {
                s += Math.abs(i);
            }
            if (Math.abs(target) > s) {
                return 0;
            }
            int[][] f = new int[n + 1][2 * s + 1];
            f[0][0 + s] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = -s; j <= s; j++) {
                    if ((j - x) + s >= 0) {
                        f[i][j + s] += f[i - 1][(j - x) + s];
                    }
                    if ((j + x) + s <= 2 * s) {
                        f[i][j + s] += f[i - 1][(j + x) + s];
                    }
                }
            }
            return f[n][target + s];
        }


    }

    static class f2 {
        f2() {
            int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
            System.out.println(targetSumWays);
        }

        public int findTargetSumWays(int[] nums, int target) {
            return dfs(nums, target, 0, 0);
        }

        Map<String, Integer> cache = new HashMap<>();

        public int dfs(int[] nums, int target, int u, int cur) {
            String key = u + "_" + cur;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            if (u == nums.length) {
                cache.put(key, cur == target ? 1 : 0);
                return cache.get(key);
            }
            int left = dfs(nums, target, u + 1, cur + nums[u]);
            int right = dfs(nums, target, u + 1, cur - nums[u]);
            cache.put(key, left + right);
            return cache.get(key);
        }


    }

    static class f1_2 {
        f1_2() {
            int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
            System.out.println(targetSumWays);
        }

        int ans = 0;

        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, target, 0, 0);
            return ans;
        }

        public void dfs(int[] nums, int target, int u, int cur) {
            if (u == nums.length) {
                ans += cur == target ? 1 : 0;
                return;
            }
            dfs(nums, target, u + 1, cur + nums[u]);
            dfs(nums, target, u + 1, cur - nums[u]);
        }

    }


    static class f1_1 {
        f1_1() {
            int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
            System.out.println(targetSumWays);
        }


        public int findTargetSumWays(int[] nums, int target) {
            return dfs(nums, target, 0, 0);
        }

        public int dfs(int[] nums, int target, int u, int cur) {
            if (u == nums.length) {
                return cur == target ? 1 : 0;
            }
            int left = dfs(nums, target, u + 1, cur + nums[u]);
            int right = dfs(nums, target, u + 1, cur - nums[u]);
            return left + right;
        }
    }

}
