package leetcode.everyday;

class Solution0070 {

     public static void main(String[] args) {
        new Solution0070().climbStairs(9);
    }


    public int climbStairs(int n) {
        int x1 = 1;
        int x2 = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = x1 + x2;
            x1 = x2;
            x2 = temp;
        }
        return x2;
    }

    public static int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
