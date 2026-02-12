package leetcode.problems;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
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
