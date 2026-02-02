package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution0290 {

    static void main(String[] args) {
        new Solution0290().wordPattern("abba", "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        String[] s2 = pattern.split("");
        return check(s1, s2) && check(s2, s1);
    }

    private boolean check(String[] strs1, String[] strs2) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < strs1.length; i++) {
            String s1 = strs1[i];
            String s2 = strs2[i];
            if (map.containsKey(s1)) {
                if (!map.get(s1).equals(s2)) {
                    return false;
                }
            } else {
                map.put(s1, s2);
            }
        }
        return true;
    }


}
