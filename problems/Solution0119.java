package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

class Solution0119 {

    static void main(String[] args) {
        new Solution0119().getRow(4);
    }

    static List<List<Integer>> ans = new ArrayList<>(34);

    static {
        ans.add(List.of(1));
        for (int i = 1; i < 34; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return ans.get(rowIndex);
    }
}
