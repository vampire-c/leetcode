package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
class Solution0345 {

    static void main(String[] args) {
        new Solution0345().reverseVowels("leetcode");
    }

    public String reverseVowels(String s) {
        char[] ca = s.toCharArray();
        for (int left = 0, right = ca.length - 1; left < right; ) {
            if (!isVowel(ca[left])) {
                left++;
                continue;
            }
            if (!isVowel(ca[right])) {
                right--;
                continue;
            }
            char temp = ca[left];
            ca[left] = ca[right];
            ca[right] = temp;
            left++;
            right--;
        }
        return new String(ca);
    }

    public boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
                a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }

    public String reverseVowels1(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] ca = s.toCharArray();
        for (int left = 0, right = ca.length - 1; left < right; ) {
            if (!set.contains(ca[left])) {
                left++;
                continue;
            }
            if (!set.contains(ca[right])) {
                right--;
                continue;
            }
            char temp = ca[left];
            ca[left] = ca[right];
            ca[right] = temp;
            left++;
            right--;
        }
        return new String(ca);
    }
}
