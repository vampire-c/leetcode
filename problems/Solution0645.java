package leetcode.problems;

/*
集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
导致集合里面某一个数字复制成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
给定一个数组 nums 代表了该集合发生错误后的结果。
请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
class Solution0645 {

    static void main(String[] args) {
        new Solution0645().findErrorNums(new int[]{1, 2, 2, 4});
    }


    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                a = nums[i];
                b = i == 0 ? 1 : nums[i - 1] + 1;
            }
        }
        return new int[]{a, b};
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int tot = n * (n + 1) / 2;
        int[] cnts = new int[n + 1];
        int sum = 0, set = 0;
        for (int num : nums) {
            sum += num;
            if (cnts[num] == 0) {
                set += num;
            }
            cnts[num] = 1;
        }
        return new int[]{sum - set, tot - set};
    }

    public int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        for (int x : nums) cnts[x]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnts[i] == 0) ans[1] = i;
            if (cnts[i] == 2) ans[0] = i;
        }
        return ans;
    }
}
