package leetcode.problems;

class Solution0026 {

    public static void main(String[] args) {
        new Solution0026().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length ) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return ++left;

    }
}
