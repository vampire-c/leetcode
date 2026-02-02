package leetcode.problems;

import java.util.*;

class Solution0350 {

    static void main(String[] args) {
        new Solution0350().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int x = nums1[i];
            int y = nums2[j];
            if (x < y) {
                i++;
            } else if (x > y) {
                j++;
            } else {
                ans.add(x);
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            Integer integer = map.getOrDefault(i, 0);
            if (integer > 0) {
                map.put(i, integer - 1);
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
