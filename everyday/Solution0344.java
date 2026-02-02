package leetcode.problems;

class Solution0344 {

    static void main(String[] args) {
        new Solution0344().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public void reverseString(char[] s) {
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            char tmp = s[i];
            s[i] = s[l - 1 - i];
            s[l - 1 - i] = tmp;
        }
    }

    public void reverseString1(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
