package leetcode.everyday;

public class Solution2110 {
    public static void main(String[] args) {

        int[] prices = new int[100000];

        int t = 10000;
        for (int i = 0; i < prices.length; i++) {
            prices[i] = t--;
        }
        long descentPeriods = new Solution2110().getDescentPeriods(prices);
        System.out.println(descentPeriods);
    }

    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long temp = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                temp++;
            } else {
                temp = 1;
            }
            ans += temp;
        }
        return ans;
    }

    public long getDescentPeriods1(int[] prices) {
        long ans = 0;
        long temp = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                temp++;
            } else {
                ans += temp * (temp + 1) / 2;
                temp = 1;
            }
        }
        return ans + temp * (temp + 1) / 2;
    }

}
