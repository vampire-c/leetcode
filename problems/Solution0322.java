package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;

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
