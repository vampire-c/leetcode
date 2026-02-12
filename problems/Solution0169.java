package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。
多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
class Solution0169 {

    static void main(String[] args) {
        new Solution0169().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    public int majorityElement(int[] nums) {
        int ans = 0;
        int h = 0;
        for (int num : nums) {
            if (h == 0) {
                ans = num;
                h = 1;
            } else {
                if (ans == num) {
                    h += 1;
                } else {
                    h -= 1;
                }
            }
        }
        return ans;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = nums.length;
        int n = l / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
