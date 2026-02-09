package leetcode.problems;

class Solution0121 {

    public static void main(String[] args) {
        int maxProfit = new Solution0121().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }

    public int maxProfit2(int[] prices) {
        int noStock = 0; // 第一天不持有，0
        int holdStock = -prices[0]; // 第一天持有，需要买入
        for (int i = 1; i < prices.length; i++) {
            noStock = Math.max(noStock, holdStock + prices[i]); // 第i天不持有，max(前一天不持有不变，前一天持有今天卖出+prices[i])
            holdStock = Math.max(holdStock, -prices[i]); // 第i天持有，max(前一天持有不变，前一天不持有今天买入-prices[i])
        }
        return noStock;
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; // 第一天不持有，0
        dp[0][1] = -prices[0]; // 第一天持有，需要买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 第i天不持有，max(前一天不持有不变，前一天持有今天卖出+prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]); // 第i天持有，max(前一天持有不变，前一天不持有今天买入-prices[i])
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return ans;
    }

}
