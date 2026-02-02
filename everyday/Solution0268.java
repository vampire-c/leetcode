package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution0268 {

    static void main(String[] args) {
        new Solution0268().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }

    public int missingNumber3(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
