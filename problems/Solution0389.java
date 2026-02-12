package leetcode.problems;

/*
给定两个字符串 s 和 t ，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
 */
class Solution0389 {

    static void main(String[] args) {
        new Solution0389().findTheDifference("abcd", "abcde");
        new Solution0389().findTheDifference("", "y");
    }

    public char findTheDifference(String s, String t) {
        return (char) (s + t).chars().reduce(0, (a, b) -> a ^ b);
    }
    public char findTheDifference3(String s, String t) {
        int ans = 0;
        for (char c : (s+t).toCharArray()) {
            ans ^= c;
        }
        return (char) ans;
    }

    public char findTheDifference2(String s, String t) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += c;
        }
        for (char c : t.toCharArray()) {
            ans -= c;
        }
        return (char) (0 - ans);
    }

    public char findTheDifference1(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] < 0) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
