package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
给定一个  无重复元素 的 有序 整数数组 nums 。
区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b
 */
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
