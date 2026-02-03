package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution0383 {

    static void main(String[] args) {
        new Solution0383().canConstruct("aa", "aab");
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.merge(magazine.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
