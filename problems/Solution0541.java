package leetcode.problems;

/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
class Solution0541 {

    static void main(String[] args) {
        new Solution0541().reverseStr("abcdefg", 2);
        // new Solution0541().reverseStr("abcd", 4);
        // new Solution0541().reverseStr("abcdefg", 8);
    }

    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        int i = 0;
        for (; i < s.length(); ) {
            reverse(ca, i, Math.min(i + k, s.length()) - 1);
            i += 2 * k;
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int left, int right) {
        while (left < right) {
            char tmp = ca[left];
            ca[left] = ca[right];
            ca[right] = tmp;
            left++;
            right--;
        }
    }
}
