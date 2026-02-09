package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

class Solution0217 {

    static void main(String[] args) {
        new Solution0217().containsDuplicate(new int[]{1,2,3,1});
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
