package leetcode.problems;

/*
给你一个 m x n 的矩阵 M 和一个操作数组 op 。
矩阵初始化时所有的单元格都为 0 。ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 */
class Solution0598 {

    static void main(String[] args) {
        new Solution0598().maxCount(3, 3, new int[][]{{2, 2}, {3, 3}});
    }

    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }

    public int maxCount1(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;
        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }
        return minA * minB;
    }
}
