package leetcode.problems;

import java.util.Arrays;

class Solution3075 {

    public static void main(String[] args) {
        long maximumHappinessSum = new Solution3075().maximumHappinessSum(new int[]{1, 2, 3}, 2);
        System.out.println(maximumHappinessSum);
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int l = happiness.length;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int t = happiness[--l] - i;
            if (t == 0) {
                return ans;
            }
            ans += Math.max(t, 0);
        }
        return ans;
    }
}
