package leetcode.problems;

/*
给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
class Solution0557 {

    static void main(String[] args) {
        new Solution0557().reverseWords("Let's take LeetCode contest");
    }

    public String reverseWords(String s) {
        s += " ";
        char[] ca = s.toCharArray();
        int left = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == ' ') {
                reverse(ca, left, i - 1);
                left = i + 1;
            }
        }

        return String.valueOf(ca).trim();
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

    public String reverseWords1(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            sb.append(reverse(str));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String reverse(String str) {
        char[] ca = str.toCharArray();
        int l = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = l - 1; i >= 0; i--) {
            sb.append(ca[i]);
        }
        return sb.toString();
    }
}
