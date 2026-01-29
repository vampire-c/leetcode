package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution2976 {

    static void main(String[] args) {
        new Solution2976().minimumCost(
                "abcd",
                "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}
        );
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            char c = original[i];
            if (map.containsKey(c)) {
                if (cost[map.get(c)] > cost[i]) {
                    map.put(c, i);
                }
            } else {
                map.put(c, i);
            }
        }
        for (int i = 0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);
            if (c1 != c2) {
                Integer idx = map.get(c1);
                if (changed[idx] == c2) {
                    ans += cost[i];
                    continue;
                }
                while (c1 != c2) {

                }

                ans += cost[idx];


            }
        }
        return ans;
    }
}
