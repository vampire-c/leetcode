package leetcode.everyday;

public class Solution0027 {

    public static void main(String[] args) {
        new Solution0027().removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans++] = num;
            }
        }
        return ans;
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }


}
