package leetcode.problems;

import java.util.*;

/*
给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
请注意，字符串 不区分大小写，相同字母的大小写形式都被视为在同一行。
美式键盘 中：
第一行由字符 "qwertyuiop" 组成。
第二行由字符 "asdfghjkl" 组成。
第三行由字符 "zxcvbnm" 组成。
 */
class Solution0500 {

    static void main(String[] args) {
        new Solution0500().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    public String[] findWords(String[] words) {
        // String rowIdx = "12210111011122000010020202";
        // char[] ca = rowIdx.toCharArray();
        int[] ca = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            char c0 = word.charAt(0);
            int idx = c0 > 'Z' ? ca[c0 - 'a'] : ca[c0 - 'A'];
            char[] wordCharArray = word.toCharArray();
            for (char c : wordCharArray) {
                int temp = c > 'Z' ? ca[c - 'a'] : ca[c - 'A'];
                if (idx != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }

    public String[] findWords1(String[] words) {

        Map<Character, Integer> map = new HashMap<>() {{
            put('q', 1);
            put('Q', 1);
            put('w', 1);
            put('W', 1);
            put('e', 1);
            put('E', 1);
            put('r', 1);
            put('R', 1);
            put('t', 1);
            put('T', 1);
            put('y', 1);
            put('Y', 1);
            put('u', 1);
            put('U', 1);
            put('i', 1);
            put('I', 1);
            put('o', 1);
            put('O', 1);
            put('p', 1);
            put('P', 1);
            put('a', 2);
            put('A', 2);
            put('s', 2);
            put('S', 2);
            put('d', 2);
            put('D', 2);
            put('f', 2);
            put('F', 2);
            put('g', 2);
            put('G', 2);
            put('h', 2);
            put('H', 2);
            put('j', 2);
            put('J', 2);
            put('k', 2);
            put('K', 2);
            put('l', 2);
            put('L', 2);
            put('z', 3);
            put('Z', 3);
            put('x', 3);
            put('X', 3);
            put('c', 3);
            put('C', 3);
            put('v', 3);
            put('V', 3);
            put('b', 3);
            put('B', 3);
            put('n', 3);
            put('N', 3);
            put('m', 3);
            put('M', 3);
        }};
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            Integer line = map.get(word.charAt(0));
            for (char c : word.toCharArray()) {
                if (!Objects.equals(map.get(c), line)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}
