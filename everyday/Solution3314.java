package leetcode.everyday;

import java.util.List;

public class Solution3315 {

    public static void main(String[] args) {
        new Solution3315().minBitwiseArray(List.of(2, 3, 5, 7));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            if (temp == 2) {
                ans[i] = -1;
            } else {
                int lowbit = (temp + 1) & ~temp;
                ans[i] = temp ^ (lowbit >> 1);
            }
        }
        return ans;
    }

    public int[] minBitwiseArray2(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            Integer temp = nums.get(i);
            if (temp == 2) {
                ans[i] = -1;
            } else {
                int t = ~temp;
                int lowbit = t & -t;
                ans[i] = temp ^ (lowbit >> 1);
            }
        }
        return ans;
    }

    public int[] minBitwiseArray1(List<Integer> nums) {
        int[] ints = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            Integer target = nums.get(i);
            for (int temp = 0; temp < target; temp++) {
                if ((temp | (temp + 1)) == target) {
                    ints[i] = temp;
                    break;
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = -1;
            }
        }
        return ints;
    }
}
