package leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1200 {

    static void main(String[] args) {
        new Solution1200().minimumAbsDifference(new int[]{4, 2, 1, 3});
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int x = arr[i];
            int y = arr[i + 1];
            int diff = y - x;
            if (diff < minDiff) {
                minDiff = diff;
                ans.clear();
                ans.add(List.of(x, y));
            } else if (diff == minDiff) {
                ans.add(List.of(x, y));
            }
        }
        return ans;
    }
}
