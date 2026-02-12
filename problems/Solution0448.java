package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
class Solution0448 {

    static void main(String[] args) {
        new Solution0448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[nums[i]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
