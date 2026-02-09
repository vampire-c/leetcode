package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Solution0205 {

    static void main(String[] args) {
        new Solution0205().isIsomorphic("paper", "title");
    }

    public boolean isIsomorphic(String s, String t) {
        return chack(s, t) && chack(t, s);
    }

    private static boolean chack(String s, String t) {
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            if (map.containsKey(sc[i])) {
                if (st[i] != map.get(sc[i])) {
                    return false;
                }
            } else {
                map.put(sc[i], st[i]);
            }
        }
        return true;
    }
}
