package leetcode.problems;

import java.util.Arrays;

class Solution0409 {

    static void main(String[] args) {
        new Solution0409().longestPalindrome("abccccdd");
    }

    public int longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        int n = ca.length;
        int ans = 0;
        for (int i = 1; i < n; ) {
            if (ca[i] == ca[i - 1]) {
                ans += 2;
                i += 2;
            } else {
                i++;
            }
        }
        return ans == n ? ans : ans + 1;
    }
}
