package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution0219 {

    static void main(String[] args) {
        // new Solution0219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
        // new Solution0219().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        new Solution0219().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
