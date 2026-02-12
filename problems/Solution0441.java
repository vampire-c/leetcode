package leetcode.problems;

/*
你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
阶梯的最后一行 可能 是不完整的。
给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 */
class Solution0441 {

    static void main(String[] args) {
        new Solution0441().arrangeCoins(8);
    }

    public int arrangeCoins(int n) {// 1,2,3,4,5,6,7,8
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid * (mid + 1) <= n * 2) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public int arrangeCoins3(int n) {
        return (int) (Math.pow(8 * n + 1, 2) - 1) / 2;
    }

    public int arrangeCoins2(int n) {
        int i = 0, sum = 0;
        while (sum <= n) {
            sum += ++i;
        }
        return --i;
    }

    public int arrangeCoins1(int n) {
        int ans = 0, i = 1;
        while (n > i) {
            n -= i++;
            ans++;
        }
        return ans;
    }
}
