package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 */
class Solution1582 {

    static void main(String[] args) {

        int[][] ints = {
                {1, 1, 0},
                {0, 0, 1},
                {1, 0, 0}

                // {1, 0, 0},
                // {0, 1, 0},
                // {0, 0, 1}

                // {0, 0},
                // {0, 0},
                // {1, 0}

        };

        new Solution1582().numSpecial(ints);
    }

    public int numSpecial(int[][] mat) {
        int ans = 0;
        next:
        for (int[] row : mat) {
            int col = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    continue;
                }
                if (col >= 0) {
                    continue next;
                }
                col = j;
            }
            if (col <0){
                continue;
            }

            boolean b = false;
            for (int[] ints : mat) {
                if (ints[col] == 0){
                    continue;
                }
                if (b){
                    continue next;
                }
                b = true;
            }
            ans++;
        }
        return ans;
    }

    public int numSpecial3x(int[][] mat) {
        int ans = 0;
        next:
        for (int[] row : mat) {
            int rowCount = 0;
            int index = -1;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    rowCount++;
                    index = i;
                    if (rowCount > 1) {
                        continue next;
                    }
                }
            }
            if (rowCount != 1) {
                continue;
            }
            int colSum = 0;
            for (int[] ints : mat) {
                colSum += ints[index];
                if (colSum > 1) {
                    continue next;
                }
            }
            if (colSum == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int numSpecial2(int[][] mat) {
        int ans = 0;
        for (int[] row : mat) {
            int rowCount = 0;
            int index = -1;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    rowCount++;
                    index = i;
                }
            }
            if (rowCount != 1) {
                continue;
            }
            int colSum = 0;
            for (int[] ints : mat) {
                colSum += ints[index];
            }
            if (colSum == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int numSpecial1(int[][] mat) {
        int ans = 0;
        int y = mat.length;
        int x = mat[0].length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < y; i++) {
            int count = 0;
            int idx = -1;
            for (int j = 0; j < x; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    idx = j;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                set.add(idx);
            }
        }

        for (Integer j : set) {
            int count = 0;
            for (int i = 0; i < y; i++) {
                if (mat[i][j] == 1) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                ans++;
            }
        }

        return ans;
    }
}
