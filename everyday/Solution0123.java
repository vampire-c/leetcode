package leetcode.problems;

class Solution0123 {

    public static void main(String[] args) {
        int maxProfit = new Solution0123().maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 });
        System.out.println(maxProfit);
    }

    public int maxProfit1(int[] prices) {
        int buy1 = -prices[0]; // 买一次(第1天买一次)
        int sell1 = 0; // 买卖一次(第1天买一次之后，卖一次)
        int buy2 = -prices[0]; // 买两次(第1天买一次之后，卖一次，再买一次)
        int sell2 = 0; // 买卖两次(第1天买一次之后，卖一次，再买一次，再卖掉)
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]); // 只能买一次，前一天买，或者今天买(-今天买入价格)，
            sell1 = Math.max(sell1, buy1 + prices[i]); // 只能卖一次，前一天卖，或者今天卖(买入价格+今天卖出价格)
            buy2 = Math.max(buy2, sell1 - prices[i]); // 买两次，前一天买，或者今天买卖之后，再卖一次(买入卖处价格-今天买入价格)
            sell2 = Math.max(sell2, buy2 + prices[i]); // 卖两次，前一天卖，或者今天买卖之后，再卖一次(买入卖出买入价格+今天卖出价格)
        }
        return sell2;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0]; // 买一次(第1天买一次)
        dp[0][1] = 0; // 买卖一次(第1天买一次之后，卖一次)
        dp[0][2] = -prices[0]; // 买两次(第1天买一次之后，卖一次，再买一次)
        dp[0][3] = 0; // 买卖两次(第1天买一次之后，卖一次，再买一次，再卖掉)
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // 只能买一次，前一天买，或者今天买(-今天买入价格)，
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]); // 只能卖一次，前一天卖，或者今天卖(买入价格+今天卖出价格)
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]); // 买两次，前一天买，或者今天买卖之后，再卖一次(买入卖处价格-今天买入价格)
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]); // 卖两次，前一天卖，或者今天买卖之后，再卖一次(买入卖出买入价格+今天卖出价格)
        }
        return dp[prices.length - 1][3];
    }
}
