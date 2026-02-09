package leetcode.problems;

class Solution0283 {

    public static void main(String[] args) {
        // new Solution0283().moveZeroes(new int[]{0, 1, 0, 3, 12, 0, 1, 0, 1});
        new Solution0283().moveZeroes(new int[]{1, 1});
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
        System.out.println(nums);
    }
}
