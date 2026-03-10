package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定两个字符串数组 list1 和 list2，找到 索引和最小的公共字符串。
公共字符串 是同时出现在 list1 和 list2 中的字符串。
具有 最小索引和的公共字符串 是指，如果它在 list1[i] 和 list2[j] 中出现，那么 i + j 应该是所有其他 公共字符串 中的最小值。
返回所有 具有最小索引和的公共字符串。以 任何顺序 返回答案。
 */
class Solution0599 {

    static void main(String[] args) {
        String[] strings1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] strings2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        new Solution0599().findRestaurant(strings1, strings2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        List<String> ret = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if (i + j < indexSum) {
                    ret.clear();
                    ret.add(list2[i]);
                    indexSum = i + j;
                } else if (i + j == indexSum) {
                    ret.add(list2[i]);
                }

            }
        }
        return ret.toArray(new String[ret.size()]);
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        int l1 = list1.length, l2 = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l2; i++) {
            String s = list2[i];
            if (!map.containsKey(s)) {
                continue;
            }
            if (i + map.get(s) < min) {
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) == min) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
