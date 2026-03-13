package leetcode.problems;

/*
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
class Solution0674 {

    static void main(String[] args) {
        // new Solution0674().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        new Solution0674().findLengthOfLCIS(new int[]{1, 3, 5, 7});
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0, temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                temp++;
            } else if (nums[i - 1] >= nums[i]) {
                ans = Math.max(ans, temp + 1);
                temp = 0;
            }
        }
        return Math.max(ans, temp + 1);
    }
}
