package leetcode.problems;

/*
给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。
你也会得到一个整数 k 。
我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。
此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
返回 重新格式化的许可密钥 。
 */
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
