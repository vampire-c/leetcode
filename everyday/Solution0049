package leetcode.everyday;

import java.util.*;

public class Solution0049 {

    public static void main(String[] args) {
        new Solution0049().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (map.containsKey(new String(charArray))) {
                List<String> list = map.get(new String(charArray));
                list.add(str);
                map.put(new String(charArray), list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(new String(charArray), list);
            }
            map
                    .computeIfAbsent(
                            new String(charArray),
                            _ -> new ArrayList<>()
                    )
                    .add(str);
        }
        return new ArrayList<>(map.values());
    }
}
