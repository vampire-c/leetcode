package leetcode.problems;

import java.util.Arrays;

/*
给你 3 个正整数 zero ，one 和 limit 。
一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
0 在 arr 中出现次数 恰好 为 zero 。
1 在 arr 中出现次数 恰好 为 one 。
arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
请你返回 稳定 二进制数组的 总 数目。
由于答案可能很大，将它对 109 + 7 取余 后返回。
 */
class Solution3129 {

    static void main(String[] args) {
        new Solution3129().numberOfStableArrays(1, 1, 2);
    }

    private static int MOD = 1_000_000_007;
    private static int MX = 1001;
    private static long[] F = new long[MX];
    private static long[] INV_F = new long[MX];

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }
        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        if (zero > one) {
            int t = zero;
            zero = one;
            one = t;
        }
        long[] f0 = new long[zero + 3];
        for (int i = (zero - 1) / limit + 1; i <= zero; i++) {
            f0[i] = comb(zero - 1, i - 1);
            for (int j = 1; j <= (zero - i) / limit; j++) {
                f0[i] = (f0[i] + (1 - j % 2 * 2) * comb(i, j) * comb(zero - j * limit - 1, i - 1)) % MOD;
            }
        }

        long ans = 0;
        for (int i = (one - 1) / limit + 1; i <= Math.min(one, zero + 1); i++) {
            long f1 = comb(one - 1, i - 1);
            for (int j = 1; j <= (one - i) / limit; j++) {
                f1 = (f1 + (1 - j % 2 * 2) * comb(i, j) * comb(one - j * limit - 1, i - 1)) % MOD;
            }
            ans = (ans + (f0[i - 1] + f0[i] * 2 + f0[i + 1]) * f1) % MOD;
        }
        // 保证结果非负
        return (int) ((ans + MOD) % MOD);
    }

    private long comb(int n, int m) {
        return F[n] * INV_F[m] % MOD * INV_F[n - m] % MOD;
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }


    public int numberOfStableArrays3(int zero, int one, int limit) {
        int[][][] f = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // +MOD 保证答案非负
                f[i][j][0] = (int) (
                        ((long) f[i - 1][j][0] + f[i - 1][j][1] + (i > limit ? MOD - f[i - limit - 1][j][1] : 0))
                                % MOD);
                f[i][j][1] = (int) (
                        ((long) f[i][j - 1][0] + f[i][j - 1][1] + (j > limit ? MOD - f[i][j - limit - 1][0] : 0))
                                % MOD);
            }
        }
        return (f[zero][one][0] + f[zero][one][1]) % MOD;
    }

    public int numberOfStableArrays2(int zero, int one, int limit) {
        int[][][] memo = new int[zero + 1][one + 1][2];
        for (int[][] ints : memo) {
            for (int[] i : ints) {
                Arrays.fill(i, -1);
                // -1 表示没有计算过
            }
        }
        return (dfs(zero, one, 0, limit, memo) + dfs(zero, one, 1, limit, memo)) % MOD;
    }

    private int dfs(int i, int j, int k, int limit, int[][][] memo) {
        if (i == 0) {
            // 递归边界
            return k == 1 && j <= limit ? 1 : 0;
        }
        if (j == 0) {
            // 递归边界
            return k == 0 && i <= limit ? 1 : 0;
        }
        if (memo[i][j][k] != -1) {
            // 之前计算过
            return memo[i][j][k];
        }
        if (k == 0) {
            // +MOD 保证答案非负
            memo[i][j][k] = (int) (
                    ((long) dfs(i - 1, j, 0, limit, memo) + dfs(i - 1, j, 1, limit, memo) +
                            (i > limit ? MOD - dfs(i - limit - 1, j, 1, limit, memo) : 0))
                            % MOD);
        } else {
            memo[i][j][k] = (int) (
                    ((long) dfs(i, j - 1, 0, limit, memo) + dfs(i, j - 1, 1, limit, memo) +
                            (j > limit ? MOD - dfs(i, j - limit - 1, 0, limit, memo) : 0))
                            % MOD);
        }
        return memo[i][j][k];
    }


    int[][][] memo;
    int limit;

    public int numberOfStableArrays1(int zero, int one, int limit) {
        this.memo = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        this.limit = limit;
        return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD;
    }

    public int dp(int zero, int one, int lastBit) {
        if (zero == 0) {
            return (lastBit == 0 || one > limit) ? 0 : 1;
        } else if (one == 0) {
            return (lastBit == 1 || zero > limit) ? 0 : 1;
        }

        if (memo[zero][one][lastBit] == -1) {
            int res = 0;
            if (lastBit == 0) {
                res = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1)) % MOD;
                if (zero > limit) {
                    res = (res - dp(zero - limit - 1, one, 1) + MOD) % MOD;
                }
            } else {
                res = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD;
                if (one > limit) {
                    res = (res - dp(zero, one - limit - 1, 0) + MOD) % MOD;
                }
            }
            memo[zero][one][lastBit] = res % MOD;
        }
        return memo[zero][one][lastBit];

    }

    public int numberOfStableArrays0(int zero, int one, int limit) {
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int lastBit = 0; lastBit <= 1; lastBit++) {
                    if (i == 0) {
                        if (lastBit == 0 || j > limit) {
                            dp[i][j][lastBit] = 0;
                        } else {
                            dp[i][j][lastBit] = 1;
                        }
                    } else if (j == 0) {
                        if (lastBit == 1 || i > limit) {
                            dp[i][j][lastBit] = 0;
                        } else {
                            dp[i][j][lastBit] = 1;
                        }
                    } else if (lastBit == 0) {
                        dp[i][j][lastBit] = dp[i - 1][j][0] + dp[i + 1][j][1];
                        if (i > limit) {
                            dp[i][j][lastBit] -= dp[i - limit - 1][j][1];
                        }
                    } else {
                        dp[i][j][lastBit] = dp[i][j - 1][0] + dp[i][j - 1][1];
                        if (j > limit) {
                            dp[i][j][lastBit] -= dp[i][j - limit - 1][0];
                        }
                    }
                    dp[i][j][lastBit] %= MOD;
                    if (dp[i][j][lastBit] < 0) {
                        dp[i][j][lastBit] += MOD;
                    }
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }


}
