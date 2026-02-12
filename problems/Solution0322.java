package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
 */
class Solution0322 {

    public static void main(String[] args) {
        // new Solution0322().coinChange(new int[]{1, 2, 5}, 11);
        new Solution0322().coinChange(new int[]{186, 419, 83, 408}, 6249);
    }

    public int coinChange(int[] coins, int amount) {
        Integer[] coinObjects = Arrays.stream(coins)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        int ans = 0;
        for (int coin : coinObjects) {
            while (amount >= coin) {
                amount -= coin;
                ans++;
            }
        }
        return amount == 0 ? ans : -1;
    }
}
