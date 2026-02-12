package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */
class Solution0438 {

    public static void main(String[] args) {
        List<Integer> anagrams = new Solution0438().findAnagrams(new String("cbaebabacd"), new String("abc"));
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] cntP = new int[26];
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int[] cntS = new int[26];
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++;
            int left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(cntS, cntP)) {
                ans.add(left);
            }
            cntS[s.charAt(left) - 'a']--;
        }
        return ans;
    }


    public List<Integer> findAnagrams1(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        char[] pca = p.toCharArray();
        Arrays.sort(pca);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= sl - pl; i++) {
            char[] ca = s.substring(i, i + pl).toCharArray();
            Arrays.sort(ca);
            if (Arrays.equals(ca, pca)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
