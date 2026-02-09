package leetcode.problems;

import java.util.Map;

public class Solution0013 {

    public static void main(String[] args) {
        new Solution0013().romanToInt("MCMXCIV");
    }

    Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        char[] ca = s.toCharArray();
        int sl = s.length();
        int ans = 0;
        for (int i = 0; i < sl - 1; i++) {
            int x = map.get(ca[i]);
            int y = map.get(ca[i + 1]);
            ans += x < y ? -x : x;
        }
        return ans + map.get(ca[sl - 1]);
    }

    public int romanToInt1(String s) {
        int ans = 0;
        char[] ca = s.toCharArray();
        for (int i = ca.length - 1; i >= 0; i--) {
            char c = ca[i];
            switch (c) {
                case 'I' -> ans += 1 * (ans >= 5 ? -1 : 1);
                case 'V' -> ans += 5;
                case 'X' -> ans += 10 * (ans >= 50 ? -1 : 1);
                case 'L' -> ans += 50;
                case 'C' -> ans += 100 * (ans >= 500 ? -1 : 1);
                case 'D' -> ans += 500;
                case 'M' -> ans += 1000;
            }
        }
        return ans;
    }


}
