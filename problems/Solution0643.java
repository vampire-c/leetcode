package leetcode.problems;

/*
给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
任何误差小于 10-5 的答案都将被视为正确答案。
 */
class Solution0643 {

    static void main(String[] args) {
        int[] ints = {1, 12, -5, -6, 50, 3};
        new Solution0643().findMaxAverage(ints, 4);
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public double findMaxAverage1(int[] nums, int k) {
        int maxS = Integer.MIN_VALUE; // 窗口元素和最大值
        int s = 0; // 维护窗口元素和
        for (int i = 0; i < nums.length; i++) {
            // 1.进入窗口
            s += nums[i];
            if (i < k - 1) { // 窗口大小不足 k
                continue;
            }
            // 2.更新答案
            maxS = Math.max(maxS, s);
            // 3.离开窗口
            s -= nums[i - k + 1];
        }
        return (double) maxS / k;
    }
}
