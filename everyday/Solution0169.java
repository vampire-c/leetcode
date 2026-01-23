package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

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
