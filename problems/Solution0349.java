package leetcode.problems;


import java.util.*;
import java.util.stream.Collectors;

/*
给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。
我们可以 不考虑输出结果的顺序 。
 */
class Solution0349 {

    static void main(String[] args) {
        new Solution0349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(set::contains).toArray();
    }


    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            if (set.remove(i)) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
