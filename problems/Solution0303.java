package leetcode.problems;

public class Solution0303 {

    static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


}

class NumArray {

    int[] ints;

    public NumArray(int[] nums) {
        ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[i + 1] = ints[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return ints[right + 1] - ints[left];
    }
}

class NumArray1 {


    int[] ints;

    public NumArray1(int[] nums) {
        ints = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += ints[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
