package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

class Solution0136 {

    static void main(String[] args) {
        new Solution0136().singleNumber(new int[]{4, 1, 2, 1, 2});
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
