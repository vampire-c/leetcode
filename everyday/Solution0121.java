package leetcode.everyday;

public class Solution0121 {


    public static void main(String[] args) {
        int maxProfit = new Solution0121().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
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
