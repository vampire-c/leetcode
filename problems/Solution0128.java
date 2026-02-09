package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

class Solution0128 {

    public static void main(String[] args) {
        // System.out.println(new Solution0128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Solution0128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        int res = 0;
        for (Integer x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            res = Math.max(res, y - x);
            if (res * 2 >= size) {
                break;
            }
        }
        return res;
    }
}
