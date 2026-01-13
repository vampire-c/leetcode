package leetcode.math;

import java.util.HashSet;

class Solution2Q2 {


    public static void main(String[] args) {
        System.out.println(new Solution2Q2().smallestRepunitDivByK(3));
    }


    public int smallestRepunitDivByK1(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int m = phi(k * 9);

        // 从小到大枚举不超过 sqrt(m) 的因子
        int i = 1;
        for (; i * i <= m; i++) {
            if (m % i == 0 && pow(10, i, k * 9) == 1) {
                return i;
            }
        }

        // 从小到大枚举不低于 sqrt(m) 的因子
        for (i--; ; i--) {
            if (m % i == 0 && pow(10, m / i, k * 9) == 1) {
                return m / i;
            }
        }
    }

    // 计算欧拉函数（n 以内的与 n 互质的数的个数）
    private int phi(int n) {
        int res = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                res = res / i * (i - 1);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            res = res / n * (n - 1);
        }
        return res;
    }

    // 快速幂，返回 pow(x, n) % mod
    private long pow(long x, int n, long mod) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }

    public int smallestRepunitDivByK2(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int x = 1 % k;
        for (int i = 1; ; i++) { // 一定有解
            if (x == 0) {
                return i;
            }
            x = (x * 10 + 1) % k;
        }
    }



    public int smallestRepunitDivByK(int k) {
        var set = new HashSet<>();
        int x = 1 % k;
        while (x > 0 && set.add(x)) {
            x = (x * 10 + 1) % k;
        }

        if (x > 0) {
            return -1;
        } else {
            return set.size() + 1;
        }
    }
}
