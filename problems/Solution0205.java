package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
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
