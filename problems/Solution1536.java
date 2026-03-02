package leetcode.problems;

import java.util.Arrays;

/*
给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 */
class Solution1536 {

    static void main(String[] args) {
        int[][] ints =
                new int[][]{
                        {0, 0, 1},
                        {1, 1, 0},
                        {1, 0, 0},
                };
        new Solution1536().minSwaps(ints);
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = -1;
            for (int j = i; j < n; j++) {
                if (pos[j] <= i) {
                    ans += j - i;
                    k = j;
                    break;
                }
            }
            if (k >= 0) {
                for (int j = k; j > i; j--) {
                    int tmp = pos[j];
                    pos[j] = pos[j - 1];
                    pos[j - 1] = tmp;
                }
            } else {
                return -1;
            }

        }
        return ans;
    }

    public int minSwaps1(int[][] grid) {
        int n = grid.length;
        int[] tailZeros = new int[n];
        for (int i = 0; i < n; i++) {
            tailZeros[i] = n;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    tailZeros[i] = n - 1 - j;
                    break;
                }
            }
        }

        int ans = 0;
        next:
        for (int i = 0; i < n - 1; i++) {
            int needZeros = n - 1 - i;
            for (int j = i; j < n; j++) {
                if (tailZeros[j] >= needZeros) {
                    ans += j - i;
                    System.arraycopy(tailZeros, i, tailZeros, i + 1, j - i);
                    continue next;
                }
            }
            return -1;
        }
        return ans;
    }
}
