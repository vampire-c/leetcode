package leetcode.problems;

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
