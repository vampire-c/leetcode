package leetcode.everyday;

import java.util.Arrays;

class Solution3074 {

    public static void main(String[] args) {
        new Solution3074().minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2});
    }

    public int minimumBoxes1(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) sum += i;
        Arrays.sort(capacity);
        int m = capacity.length;
        int i = m - 1;
        while (sum > 0) {
            sum-=capacity[i--];
        }
        return m - 1 - i;

    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) sum += i;

        Arrays.sort(capacity);

        int ans = 0, s = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum <= s) {
                break;
            }
            ans++;
            s += capacity[i];
        }
        return ans;
    }
}
