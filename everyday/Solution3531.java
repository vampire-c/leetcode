package leetcode.everyday;

import java.util.Arrays;

class Solution3531 {

    public static void main(String[] args) {

        new Solution3531().countCoveredBuildings(3, new int[][]{{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}});
        // new Solution3531().countCoveredBuildings(5, new int[][]{{1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}, {2, 3}, {2, 5}, {2, 2}});
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];
        Arrays.fill(rowMin, n + 1);
        Arrays.fill(colMin, n + 1);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }

        int count = 0;
        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            if (rowMin[y] < x && x < rowMax[y] && colMin[x] < y && y < colMax[x]) {
                count++;
            }
        }
        return count;
    }
}
