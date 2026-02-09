package leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution0387 {

    public static void main(String[] args) {
        new Solution0387().firstUniqChar("leetcode");
        new Solution0387().firstUniqChar("aabb");
        new Solution0387().firstUniqChar("aadadaad");
        new Solution0387().firstUniqChar("loveleetcode");
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] ca = s.toCharArray();
        for (char c : ca) {
            count[c - 'a']++;
        }
        for (char c : ca) {
            if (count[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }


    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        for (Integer value : map.values()) {
            if (value >= 0) {
                return value;
            }
        }
        return -1;
    }
}
