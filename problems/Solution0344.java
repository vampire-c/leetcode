package leetcode.problems;

/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
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
