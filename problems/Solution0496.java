package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
class Solution0496 {

    static void main(String[] args) {
        new Solution0496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        // new Solution0496().nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = l2 - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] ans = new int[l1];
        for (int i = 0; i < l1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] ans = new int[l1];
        for (int i = 0; i < l1; i++) {
            int j = 0;
            while (j < l2 && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < l2 && nums2[k] < nums2[j]) {
                k++;
            }
            ans[i] = k < l2 ? nums2[k] : -1;
        }
        return ans;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            Integer index = map.get(num);
            boolean flag = false;
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > num) {
                    ans[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
