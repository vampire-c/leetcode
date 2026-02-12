package leetcode.problems;

import java.util.Arrays;

/*
给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
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
