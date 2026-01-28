package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

class Solution0228 {

    static void main(String[] args) {
        // new Solution0228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        new Solution0228().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->").append(nums[high]);
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}
