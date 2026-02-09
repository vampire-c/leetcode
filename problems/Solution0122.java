package leetcode.problems;

public class Solution0122 {
    public static void main(String[] args) {
        int maxProfit = new Solution0122().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int holdStock = 0;// 第一天不持有股票时的利润
        int noStock = -prices[0];// 第一天持有股票时的利润
        for (int i = 1; i < prices.length; i++) {
            holdStock = Math.max(holdStock, noStock + prices[i]);
            // 状态转移方程：第i天不持有股票 = max(前一天不持有, 前天持有+今天卖出价格)
            noStock = Math.max(noStock, holdStock - prices[i]);
            // 状态转移方程：第i天持有股票 = max(前一天持有, 前天不持有-今天买入价格)
        }
        return holdStock;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;// 表示第0天不持有股票时的利润
        dp[0][1] = -prices[0];// 表示第0天持有股票时的利润
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 状态转移方程：第i天不持有股票 = max(前一天也不持有, 前一天持有+今天卖出价格)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 状态转移方程：第i天持有股票 = max(前一天也持有, 前一天不持有-今天买入价格)
        }
        return dp[n - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
