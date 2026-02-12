package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 */
class Solution0242 {

    static void main(String[] args) {
        // new Solution0242().isAnagram("anagram", "nagaram");
        new Solution0242().isAnagram("rat", "car");
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // if (map.containsKey(c)) {
            //     map.put(c, map.get(c) + 1);
            // } else {
            //     map.put(c, 1);
            // }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // if (map.containsKey(c)) {
            //     map.put(c, map.get(c) - 1);
            // } else {
            //     return false;
            // }
            // if (map.get(c) == 0) {
            //     map.remove(c);
            // }
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        // return map.isEmpty();
        return true;
    }
}
