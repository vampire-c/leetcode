package leetcode.problems;

import java.util.Arrays;

class Solution0392 {

    static void main(String[] args) {
        new Solution0392().isSubsequence("abc", "ahbgdc");
        // new Solution0392().isSubsequence("axc", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public boolean isSubsequence3(String s, String t) {
        int n = t.length();
        int[][] dp = new int[n + 1][26];
        Arrays.fill(dp[n], n);
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1].clone();
            dp[i][t.charAt(i) - 'a'] = i;
            System.out.println();
        }

        int i = -1;
        for (char c : s.toCharArray()) {
            i = dp[i + 1][c - 'a'];
            if (i == n) {
                return false;
            }
        }
        return true;
    }


    public boolean isSubsequence2(String s, String t) {
        if (s.isEmpty()) return true;
        int index = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(index) == c && ++index == s.length()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.isEmpty()) return true;
        char[] sca = s.toCharArray();
        char[] tca = t.toCharArray();
        for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if (sca[i] == tca[j] && ++i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
