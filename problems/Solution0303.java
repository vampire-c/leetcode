package leetcode.problems;

/*
给定一个整数数组  nums，处理以下类型的多个查询:
计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：
NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int left, int right) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 */
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
