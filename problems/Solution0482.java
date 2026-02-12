package leetcode.problems;

class Solution0482 {

    static void main(String[] args) {
        new Solution0482().licenseKeyFormatting("5F3Z-2e-9-w", 4);
        // new Solution0482().licenseKeyFormatting("--a-a-a-a--", 2);
        // new Solution0482().licenseKeyFormatting("-", 1);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            if (cnt == k && (cnt = 0) >= 0) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public String licenseKeyFormatting1(String s, int k) {
        char[] ca = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = ca.length - 1; i >= 0; i--) {
            char c = ca[i];
            if (c == '-') {
                continue;
            }
            sb.append(c);
            if (++count == k && i > 0) {
                sb.append("-");
                count = 0;
            }
        }
        String str = sb.reverse().toString().toUpperCase();
        if (str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
        }
        return str;
    }
}
