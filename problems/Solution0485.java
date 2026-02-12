package leetcode.problems;

/*
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
class Solution0485 {

    static void main(String[] args) {
        new Solution0485().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }

        return Math.max(ans, count);
    }
}
