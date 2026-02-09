package leetcode.problems;

import java.util.Arrays;

class Solution3634 {

    static void main(String[] args) {
        new Solution3634().minRemoval1(new int[]{1, 2, 6, 9}, 3);
    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int ans = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }
        return ans;
    }

    public int minRemoval1(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSave = 0;
        int left = 0;
        int i = 0;
        for (; i < nums.length; ) {
            while ((long) nums[left] * k < nums[i]) {
                left++;
            }
            maxSave = Math.max(maxSave, i - left + 1);
            i++;
        }
        return nums.length - maxSave;
    }
}
