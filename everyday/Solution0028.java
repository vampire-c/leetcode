package leetcode.problems;

public class Solution0028 {

    public static void main(String[] args) {
        new Solution0028().strStr("mississippi", "issip");
        // new Solution0028().strStr("a", "a");
    }

    public int strStr(String haystack, String needle) {
        int hl = haystack.length(), nl = needle.length();
        char[] hs = haystack.toCharArray(), ns = needle.toCharArray();
        for (int i = 0; i < hl - nl; i++) {
            int h = i, n = 0;
            while (n < nl && hs[h] == ns[n]) {
                h++;
                n++;
            }
            if (n == nl) {
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (hl >= nl) {
            for (int i = 0; i <= hl - nl; i++) {
                boolean b = false;
                if (haystack.charAt(i) == needle.charAt(0)) {
                    for (int j = 0; j < nl; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            b = true;
                            break;
                        }
                    }
                    if (!b) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
