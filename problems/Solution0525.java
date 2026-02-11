package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution0525 {

    static void main(String[] args) {
        new Solution0525().findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0});
        /*                                              -1, 1, 1, 1, 1, 1,-1,-1,-1
         */
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int ans = 0, s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i] == 0 ? -1 : 1;
            if (pos.containsKey(s)) {
                ans = Math.max(ans, i - pos.get(s));
            } else {
                pos.put(s, i);
            }
        }
        return ans;
    }

    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = nums[i] == 0 ? -1 : 1;
            sum[i + 1] = sum[i] + x;
        }
        Map<Integer, Integer> pos = new HashMap<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int s = sum[i];
            if (pos.containsKey(s)) {
                ans = Math.max(ans, i - pos.get(s));
            } else {
                pos.put(s, i);
            }
        }
        return ans;
    }

}
