package leetcode.problems;

class Solution0058 {

    public static void main(String[] args) {
        new Solution0058().lengthOfLastWord("HelloWorld");
    }

    public int lengthOfLastWord(String s) {
        char[] ca = s.toCharArray();
        int i = ca.length - 1;
        while (ca[i] == ' ') {
            i--;
        }
        int j = i - 1;
        while (j >= 0 && ca[j] != ' ') {
            j--;
        }
        return i - j;
    }

    public int lengthOfLastWord1(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
