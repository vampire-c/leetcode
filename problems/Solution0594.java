package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/*
和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 */
class Solution0594 {

    static void main(String[] args) {
        new Solution0594().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }
}
