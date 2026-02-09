package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2943 {

    public static void main(String[] args) {
        new Solution2943().maximizeSquareHoleArea(2, 3, new int[]{2, 3}, new int[]{2, 4});
        // new Solution2943().maximizeSquareHoleArea(2, 1, new int[]{2, 3}, new int[]{2});
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int ans = Math.min(longestConsecutive(hBars), longestConsecutive(vBars)) + 1;
        return ans * ans;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int ans = 0;
        for (Integer x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }

    public int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        int ans = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
            }
        }
        return ans;
    }
}
